package com.codegik.slick

import slick.jdbc.H2Profile.api.*
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import java.time.LocalDate

class OrderRepository(db: SlickDb):

  def insert(order: Order): Future[Long] =
    db.run((Tables.orders returning Tables.orders.map(_.id)) += order)

  def insertAll(orders: Seq[Order]): Future[Seq[Long]] =
    db.run((Tables.orders returning Tables.orders.map(_.id)) ++= orders)

  def findById(id: Long): Future[Option[Order]] =
    db.run(Tables.orders.filter(_.id === id).result.headOption)

  def findByUser(userId: Long): Future[Seq[Order]] =
    db.run(Tables.orders.filter(_.userId === userId).result)

  def findByProduct(product: String): Future[Seq[Order]] =
    db.run(Tables.orders.filter(_.product === product).result)

  def findAll(): Future[Seq[Order]] =
    db.run(Tables.orders.result)

  def delete(id: Long): Future[Int] =
    db.run(Tables.orders.filter(_.id === id).delete)

  def deleteByUser(userId: Long): Future[Int] =
    db.run(Tables.orders.filter(_.userId === userId).delete)

  def count(): Future[Int] =
    db.run(Tables.orders.length.result)

  def totalRevenueByUser(userId: Long): Future[Option[BigDecimal]] =
    db.run(
      Tables.orders
        .filter(_.userId === userId)
        .map(o => o.price * o.quantity.asColumnOf[BigDecimal])
        .sum
        .result
    )

  def findExpensiveOrders(minPrice: BigDecimal): Future[Seq[Order]] =
    db.run(Tables.orders.filter(_.price >= minPrice).result)

  def findOrdersAfter(date: LocalDate): Future[Seq[Order]] =
    db.run(Tables.orders.filter(_.orderDate > date).result)

  // Join: fetch users with their orders
  def findUsersWithOrders(): Future[Seq[(User, Order)]] =
    db.run(
      (Tables.users join Tables.orders on (_.id === _.userId)).result
    )

  // Left join: all users, including those without orders
  def findAllUsersWithOptionalOrders(): Future[Seq[(User, Option[Order])]] =
    db.run(
      (Tables.users joinLeft Tables.orders on (_.id === _.userId)).result
    )

  // Aggregation: total spent per user
  def totalSpentPerUser(): Future[Seq[(Long, BigDecimal)]] =
    db.run(
      Tables.orders
        .groupBy(_.userId)
        .map { case (userId, group) =>
          userId -> group.map(o => o.price * o.quantity.asColumnOf[BigDecimal]).sum
        }
        .result
    ).map(_.map { case (uid, total) => uid -> total.getOrElse(BigDecimal(0)) })

  // Aggregation: order count per user
  def orderCountPerUser(): Future[Seq[(Long, Int)]] =
    db.run(
      Tables.orders
        .groupBy(_.userId)
        .map { case (userId, group) => userId -> group.length }
        .result
    )

  // Transaction: insert user and orders atomically
  def insertUserWithOrders(user: User, orders: Seq[Order => Order]): Future[Long] =
    val action = for
      userId    <- (Tables.users returning Tables.users.map(_.id)) += user
      orderRows  = orders.map(f => f(Order(userId = userId, product = "", quantity = 0, price = 0)))
      _         <- Tables.orders ++= orderRows
    yield userId
    db.run(action.transactionally)
