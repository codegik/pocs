package com.codegik.slick

import slick.jdbc.H2Profile.api.*
import java.time.LocalDate
import java.sql.Date

// Custom column type mapping for java.time.LocalDate <-> java.sql.Date
given localDateColumnType: BaseColumnType[LocalDate] =
  MappedColumnType.base[LocalDate, Date](
    ld => Date.valueOf(ld),
    d  => d.toLocalDate
  )

class UsersTable(tag: Tag) extends Table[User](tag, "USERS"):
  def id    = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name  = column[String]("NAME")
  def email = column[String]("EMAIL", O.Unique)
  def age   = column[Int]("AGE")
  def *     = (id, name, email, age).mapTo[User]

class OrdersTable(tag: Tag) extends Table[Order](tag, "ORDERS"):
  def id        = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def userId    = column[Long]("USER_ID")
  def product   = column[String]("PRODUCT")
  def quantity  = column[Int]("QUANTITY")
  def price     = column[BigDecimal]("PRICE", O.SqlType("DECIMAL(10,2)"))
  def orderDate = column[LocalDate]("ORDER_DATE")(using localDateColumnType)

  def userFk = foreignKey("USER_FK", userId, TableQuery[UsersTable])(_.id,
    onDelete = ForeignKeyAction.Cascade)

  def * = (id, userId, product, quantity, price, orderDate).mapTo[Order]

object Tables:
  val users  = TableQuery[UsersTable]
  val orders = TableQuery[OrdersTable]

  val schema = users.schema ++ orders.schema
