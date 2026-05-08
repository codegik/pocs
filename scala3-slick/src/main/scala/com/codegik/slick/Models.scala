package com.codegik.slick

import java.time.LocalDate

case class User(
  id: Long = 0L,
  name: String,
  email: String,
  age: Int
)

case class Order(
  id: Long = 0L,
  userId: Long,
  product: String,
  quantity: Int,
  price: BigDecimal,
  orderDate: LocalDate = LocalDate.now()
)

case class UserWithOrders(user: User, orders: Seq[Order])
