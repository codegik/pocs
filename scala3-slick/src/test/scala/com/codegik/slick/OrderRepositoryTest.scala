package com.codegik.slick

import munit.FunSuite
import slick.jdbc.H2Profile.api.*
import java.time.LocalDate

class OrderRepositoryTest extends FunSuite with DbFixture:

  override def beforeEach(context: BeforeEach): Unit = resetSchema()
  override def afterAll(): Unit = db.close()

  // ── Helpers ─────────────────────────────────────────────────────────────────

  def mkUser(suffix: String, age: Int = 25): User =
    User(name = s"User$suffix", email = s"user$suffix@example.com", age = age)

  def mkOrder(userId: Long, product: String, qty: Int = 1, price: BigDecimal = 10.0): Order =
    Order(userId = userId, product = product, quantity = qty, price = price)

  def seedUserWithOrders(): (Long, Seq[Long]) =
    val uid = await(userRepo.insert(mkUser("A")))
    val oids = await(orderRepo.insertAll(Seq(
      mkOrder(uid, "Widget",  qty = 2, price = 15.00),
      mkOrder(uid, "Gadget",  qty = 1, price = 99.99),
      mkOrder(uid, "Doohickey", qty = 3, price =  5.50)
    )))
    (uid, oids)

  // ── INSERT ──────────────────────────────────────────────────────────────────

  test("insert order returns generated id > 0"):
    val uid = await(userRepo.insert(mkUser("B")))
    val oid = await(orderRepo.insert(mkOrder(uid, "Pen")))
    assert(oid > 0L)

  test("insertAll returns distinct ids for each order"):
    val uid  = await(userRepo.insert(mkUser("C")))
    val oids = await(orderRepo.insertAll(Seq(
      mkOrder(uid, "A"), mkOrder(uid, "B"), mkOrder(uid, "C")
    )))
    assertEquals(oids.size, 3)
    assertEquals(oids.distinct.size, 3)

  // ── FIND ────────────────────────────────────────────────────────────────────

  test("findById returns the correct order"):
    val uid = await(userRepo.insert(mkUser("D")))
    val oid = await(orderRepo.insert(mkOrder(uid, "Mouse", qty = 2, price = 29.99)))
    val order = await(orderRepo.findById(oid))
    assert(order.isDefined)
    assertEquals(order.get.product, "Mouse")
    assertEquals(order.get.quantity, 2)

  test("findById returns None for missing id"):
    val result = await(orderRepo.findById(99999L))
    assert(result.isEmpty)

  test("findByUser returns all orders for a user"):
    val (uid, _) = seedUserWithOrders()
    val orders = await(orderRepo.findByUser(uid))
    assertEquals(orders.size, 3)
    assert(orders.forall(_.userId == uid))

  test("findByUser returns empty for user with no orders"):
    val uid = await(userRepo.insert(mkUser("E")))
    val orders = await(orderRepo.findByUser(uid))
    assert(orders.isEmpty)

  test("findByProduct returns orders matching product name"):
    val uid = await(userRepo.insert(mkUser("F")))
    await(orderRepo.insertAll(Seq(
      mkOrder(uid, "Pen"),
      mkOrder(uid, "Pen"),
      mkOrder(uid, "Pencil")
    )))
    val pens = await(orderRepo.findByProduct("Pen"))
    assertEquals(pens.size, 2)
    assert(pens.forall(_.product == "Pen"))

  // ── COUNT ───────────────────────────────────────────────────────────────────

  test("count returns 0 when no orders"):
    assertEquals(await(orderRepo.count()), 0)

  test("count returns correct number after inserts"):
    val (_, oids) = seedUserWithOrders()
    assertEquals(await(orderRepo.count()), oids.size)

  // ── DELETE ──────────────────────────────────────────────────────────────────

  test("delete removes a single order"):
    val uid = await(userRepo.insert(mkUser("G")))
    val oid = await(orderRepo.insert(mkOrder(uid, "Stapler")))
    val affected = await(orderRepo.delete(oid))
    assertEquals(affected, 1)
    assert(await(orderRepo.findById(oid)).isEmpty)

  test("delete on non-existent id affects 0 rows"):
    assertEquals(await(orderRepo.delete(99999L)), 0)

  test("deleteByUser removes all orders for that user"):
    val (uid, _) = seedUserWithOrders()
    val affected = await(orderRepo.deleteByUser(uid))
    assertEquals(affected, 3)
    assert(await(orderRepo.findByUser(uid)).isEmpty)

  // ── AGGREGATIONS ────────────────────────────────────────────────────────────

  test("totalRevenueByUser sums price * quantity"):
    val uid = await(userRepo.insert(mkUser("H")))
    // 2 * 15.00 = 30.00  +  1 * 99.99 = 99.99  +  3 * 5.50 = 16.50  => 146.49
    await(orderRepo.insertAll(Seq(
      mkOrder(uid, "Widget",    qty = 2, price = 15.00),
      mkOrder(uid, "Gadget",    qty = 1, price = 99.99),
      mkOrder(uid, "Doohickey", qty = 3, price =  5.50)
    )))
    val total = await(orderRepo.totalRevenueByUser(uid))
    assert(total.isDefined)
    assertEquals(total.get.setScale(2), BigDecimal("146.49"))

  test("totalRevenueByUser returns None for user with no orders"):
    val uid = await(userRepo.insert(mkUser("I")))
    val total = await(orderRepo.totalRevenueByUser(uid))
    assert(total.isEmpty)

  test("totalSpentPerUser returns correct totals for multiple users"):
    val uid1 = await(userRepo.insert(mkUser("J")))
    val uid2 = await(userRepo.insert(mkUser("K")))
    await(orderRepo.insertAll(Seq(
      mkOrder(uid1, "A", qty = 1, price = 10.00),
      mkOrder(uid1, "B", qty = 2, price =  5.00),  // uid1 total = 20.00
      mkOrder(uid2, "C", qty = 3, price =  7.00)   // uid2 total = 21.00
    )))
    val totals = await(orderRepo.totalSpentPerUser()).toMap
    assertEquals(totals(uid1).setScale(2), BigDecimal("20.00"))
    assertEquals(totals(uid2).setScale(2), BigDecimal("21.00"))

  test("orderCountPerUser groups correctly"):
    val uid1 = await(userRepo.insert(mkUser("L")))
    val uid2 = await(userRepo.insert(mkUser("M")))
    await(orderRepo.insertAll(Seq(
      mkOrder(uid1, "X"), mkOrder(uid1, "Y"), mkOrder(uid2, "Z")
    )))
    val counts = await(orderRepo.orderCountPerUser()).toMap
    assertEquals(counts(uid1), 2)
    assertEquals(counts(uid2), 1)

  // ── FILTERS ─────────────────────────────────────────────────────────────────

  test("findExpensiveOrders returns only orders above threshold"):
    val uid = await(userRepo.insert(mkUser("N")))
    await(orderRepo.insertAll(Seq(
      mkOrder(uid, "Cheap",      price =   5.00),
      mkOrder(uid, "Mid",        price =  50.00),
      mkOrder(uid, "Expensive",  price = 200.00)
    )))
    val expensive = await(orderRepo.findExpensiveOrders(BigDecimal(49.99)))
    assertEquals(expensive.size, 2)
    assert(expensive.forall(_.price >= BigDecimal(49.99)))

  test("findOrdersAfter returns only orders placed after given date"):
    val uid  = await(userRepo.insert(mkUser("O")))
    val past = LocalDate.of(2024, 1, 1)
    val now  = LocalDate.now()
    val future = LocalDate.now().plusDays(1)

    // Insert two orders: one in the past, one today
    await(db.run(
      Tables.orders ++= Seq(
        Order(userId = uid, product = "Old",   quantity = 1, price = 1.0, orderDate = past),
        Order(userId = uid, product = "New",   quantity = 1, price = 1.0, orderDate = now)
      )
    ))
    val recent = await(orderRepo.findOrdersAfter(past))
    assertEquals(recent.size, 1)
    assertEquals(recent.head.product, "New")

  // ── JOINS ───────────────────────────────────────────────────────────────────

  test("findUsersWithOrders returns correct user-order pairs"):
    val uid = await(userRepo.insert(mkUser("P")))
    await(orderRepo.insertAll(Seq(
      mkOrder(uid, "Hammer"), mkOrder(uid, "Nail")
    )))
    val pairs = await(orderRepo.findUsersWithOrders())
    assertEquals(pairs.size, 2)
    assert(pairs.forall { case (user, _) => user.id == uid })
    assert(pairs.map { case (_, order) => order.product }.toSet == Set("Hammer", "Nail"))

  test("findUsersWithOrders excludes users with no orders"):
    await(userRepo.insert(mkUser("WithoutOrders")))
    val uid = await(userRepo.insert(mkUser("WithOrders")))
    await(orderRepo.insert(mkOrder(uid, "Item")))
    val pairs = await(orderRepo.findUsersWithOrders())
    assert(pairs.forall { case (u, _) => u.name == "UserWithOrders" })

  test("findAllUsersWithOptionalOrders includes users without orders as None"):
    val uid1 = await(userRepo.insert(mkUser("Q")))  // no orders
    val uid2 = await(userRepo.insert(mkUser("R")))
    await(orderRepo.insert(mkOrder(uid2, "Book")))

    val rows = await(orderRepo.findAllUsersWithOptionalOrders())
    val withoutOrders = rows.filter { case (u, o) => o.isEmpty }
    val withOrders    = rows.filter { case (u, o) => o.isDefined }

    assert(withoutOrders.exists { case (u, _) => u.id == uid1 })
    assert(withOrders.exists    { case (u, _) => u.id == uid2 })

  // ── TRANSACTION ─────────────────────────────────────────────────────────────

  test("insertUserWithOrders inserts user and orders in a single transaction"):
    val uid = await(orderRepo.insertUserWithOrders(
      mkUser("Tx"),
      Seq(
        _.copy(product = "Alpha", quantity = 1, price = 10.0),
        _.copy(product = "Beta",  quantity = 2, price = 20.0)
      )
    ))
    assert(uid > 0)
    val user   = await(userRepo.findById(uid))
    val orders = await(orderRepo.findByUser(uid))
    assert(user.isDefined)
    assertEquals(orders.size, 2)
    assert(orders.map(_.product).toSet == Set("Alpha", "Beta"))

  // ── CASCADE DELETE ───────────────────────────────────────────────────────────

  test("deleting a user cascades to their orders via FK"):
    val (uid, _) = seedUserWithOrders()
    await(userRepo.delete(uid))
    val remaining = await(orderRepo.findByUser(uid))
    assert(remaining.isEmpty)
