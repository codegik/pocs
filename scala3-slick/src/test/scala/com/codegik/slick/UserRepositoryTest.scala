package com.codegik.slick

import munit.FunSuite

class UserRepositoryTest extends FunSuite with DbFixture:

  override def beforeEach(context: BeforeEach): Unit = resetSchema()
  override def afterAll(): Unit = db.close()

  // ── INSERT ──────────────────────────────────────────────────────────────────

  test("insert returns a generated id greater than 0"):
    val id = await(userRepo.insert(User(name = "Alice", email = "alice@example.com", age = 30)))
    assert(id > 0L)

  test("inserting multiple users returns distinct ids"):
    val ids = await(userRepo.insertAll(Seq(
      User(name = "Bob",   email = "bob@example.com",   age = 25),
      User(name = "Carol", email = "carol@example.com", age = 28)
    )))
    assertEquals(ids.size, 2)
    assertEquals(ids.distinct.size, 2)

  // ── FIND BY ID ──────────────────────────────────────────────────────────────

  test("findById returns Some for existing user"):
    val id   = await(userRepo.insert(User(name = "Dave", email = "dave@example.com", age = 40)))
    val user = await(userRepo.findById(id))
    assert(user.isDefined)
    assertEquals(user.get.name, "Dave")

  test("findById returns None for missing id"):
    val user = await(userRepo.findById(9999L))
    assert(user.isEmpty)

  // ── FIND BY EMAIL ───────────────────────────────────────────────────────────

  test("findByEmail returns the correct user"):
    await(userRepo.insert(User(name = "Eve", email = "eve@example.com", age = 22)))
    val user = await(userRepo.findByEmail("eve@example.com"))
    assert(user.isDefined)
    assertEquals(user.get.name, "Eve")

  test("findByEmail returns None for unknown email"):
    val user = await(userRepo.findByEmail("nobody@nowhere.com"))
    assert(user.isEmpty)

  // ── FIND BY NAME ────────────────────────────────────────────────────────────

  test("findByName returns all users with that name"):
    await(userRepo.insertAll(Seq(
      User(name = "Sam", email = "sam1@example.com", age = 20),
      User(name = "Sam", email = "sam2@example.com", age = 21)
    )))
    val users = await(userRepo.findByName("Sam"))
    assertEquals(users.size, 2)
    assert(users.forall(_.name == "Sam"))

  test("findByName returns empty list when name not found"):
    val users = await(userRepo.findByName("Ghost"))
    assert(users.isEmpty)

  // ── FIND BY AGE RANGE ───────────────────────────────────────────────────────

  test("findByAgeRange returns users within inclusive bounds"):
    await(userRepo.insertAll(Seq(
      User(name = "A", email = "a@x.com", age = 18),
      User(name = "B", email = "b@x.com", age = 25),
      User(name = "C", email = "c@x.com", age = 35),
      User(name = "D", email = "d@x.com", age = 50)
    )))
    val users = await(userRepo.findByAgeRange(20, 35))
    assertEquals(users.size, 2)
    assert(users.map(_.name).toSet == Set("B", "C"))

  // ── COUNT & EXISTS ──────────────────────────────────────────────────────────

  test("count returns 0 on empty table"):
    assertEquals(await(userRepo.count()), 0)

  test("count reflects inserted rows"):
    await(userRepo.insertAll(Seq(
      User(name = "X", email = "x@x.com", age = 1),
      User(name = "Y", email = "y@y.com", age = 2)
    )))
    assertEquals(await(userRepo.count()), 2)

  test("existsByEmail returns true when email present"):
    await(userRepo.insert(User(name = "Pia", email = "pia@example.com", age = 29)))
    assert(await(userRepo.existsByEmail("pia@example.com")))

  test("existsByEmail returns false for absent email"):
    assert(!await(userRepo.existsByEmail("nope@example.com")))

  // ── UPDATE ──────────────────────────────────────────────────────────────────

  test("update modifies all fields"):
    val id = await(userRepo.insert(User(name = "Old", email = "old@example.com", age = 10)))
    val updated = await(userRepo.update(User(id = id, name = "New", email = "new@example.com", age = 99)))
    assertEquals(updated, 1)
    val user = await(userRepo.findById(id))
    assertEquals(user.get.name, "New")
    assertEquals(user.get.age, 99)

  test("updateEmail changes only the email field"):
    val id = await(userRepo.insert(User(name = "Zara", email = "zara@old.com", age = 33)))
    await(userRepo.updateEmail(id, "zara@new.com"))
    val user = await(userRepo.findById(id))
    assertEquals(user.get.email, "zara@new.com")
    assertEquals(user.get.name, "Zara")  // name unchanged

  test("update on non-existent id affects 0 rows"):
    val affected = await(userRepo.update(User(id = 9999L, name = "Ghost", email = "ghost@x.com", age = 0)))
    assertEquals(affected, 0)

  // ── DELETE ──────────────────────────────────────────────────────────────────

  test("delete removes the user"):
    val id = await(userRepo.insert(User(name = "ToDelete", email = "del@example.com", age = 5)))
    val affected = await(userRepo.delete(id))
    assertEquals(affected, 1)
    assert(await(userRepo.findById(id)).isEmpty)

  test("delete on non-existent id affects 0 rows"):
    assertEquals(await(userRepo.delete(9999L)), 0)

  // ── SORTING & PAGINATION ────────────────────────────────────────────────────

  test("findSortedByName ascending returns alphabetical order"):
    await(userRepo.insertAll(Seq(
      User(name = "Zoe",   email = "z@x.com", age = 1),
      User(name = "Alice", email = "a@x.com", age = 2),
      User(name = "Mike",  email = "m@x.com", age = 3)
    )))
    val names = await(userRepo.findSortedByName(ascending = true)).map(_.name)
    assertEquals(names, Seq("Alice", "Mike", "Zoe"))

  test("findSortedByName descending returns reverse alphabetical order"):
    await(userRepo.insertAll(Seq(
      User(name = "Zoe",   email = "z@x.com", age = 1),
      User(name = "Alice", email = "a@x.com", age = 2),
      User(name = "Mike",  email = "m@x.com", age = 3)
    )))
    val names = await(userRepo.findSortedByName(ascending = false)).map(_.name)
    assertEquals(names, Seq("Zoe", "Mike", "Alice"))

  test("findPaginated returns correct page"):
    await(userRepo.insertAll((1 to 10).map(i =>
      User(name = s"User$i", email = s"u$i@x.com", age = i)
    )))
    val page = await(userRepo.findPaginated(offset = 3, limit = 4))
    assertEquals(page.size, 4)
    assertEquals(page.head.name, "User4")
    assertEquals(page.last.name, "User7")

  test("findPaginated with offset beyond table size returns empty"):
    await(userRepo.insert(User(name = "Only", email = "only@x.com", age = 1)))
    val page = await(userRepo.findPaginated(offset = 100, limit = 10))
    assert(page.isEmpty)

  test("findOlderThan returns only users above threshold"):
    await(userRepo.insertAll(Seq(
      User(name = "Young", email = "young@x.com", age = 17),
      User(name = "Adult", email = "adult@x.com", age = 30),
      User(name = "Elder", email = "elder@x.com", age = 65)
    )))
    val result = await(userRepo.findOlderThan(20))
    assertEquals(result.size, 2)
    assert(result.forall(_.age > 20))

  test("findAll returns every inserted user"):
    val data = (1 to 5).map(i => User(name = s"U$i", email = s"u$i@x.com", age = i * 10))
    await(userRepo.insertAll(data))
    val all = await(userRepo.findAll())
    assertEquals(all.size, 5)
