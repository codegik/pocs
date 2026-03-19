package com.codegik

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization.{write, read}

case class Book(title: String, author: String, year: Int, isbn: Option[String])
case class Library(name: String, books: List[Book], capacity: Int)
case class User(id: Long, username: String, email: String, tags: List[String], metadata: Map[String, String])
case class Order(orderId: String, items: List[OrderItem], total: BigDecimal, customer: Customer)
case class OrderItem(productId: String, quantity: Int, price: BigDecimal)
case class Customer(customerId: String, name: String, address: Option[Address])

class JsonSerializationSpec extends AnyFlatSpec with Matchers {
  implicit val formats: Formats = DefaultFormats

  "Json4S serialization" should "handle nested objects with collections" in {
    val library = Library(
      "City Library",
      List(
        Book("Scala for the Impatient", "Cay Horstmann", 2016, Some("978-0134540566")),
        Book("Functional Programming in Scala", "Paul Chiusano", 2014, None),
        Book("Programming in Scala", "Martin Odersky", 2016, Some("978-0981531687"))
      ),
      1000
    )

    val json = write(library)
    val deserialized = read[Library](json)

    deserialized.name shouldBe "City Library"
    deserialized.books should have size 3
    deserialized.books.head.title shouldBe "Scala for the Impatient"
    deserialized.books(1).isbn shouldBe None
    deserialized.capacity shouldBe 1000
  }

  it should "serialize objects with maps and lists" in {
    val user = User(
      123L,
      "johndoe",
      "john@test.com",
      List("scala", "functional", "programming"),
      Map("role" -> "developer", "level" -> "senior", "team" -> "backend")
    )

    val json = write(user)
    val deserialized = read[User](json)

    deserialized.id shouldBe 123L
    deserialized.tags should contain allOf ("scala", "functional", "programming")
    deserialized.metadata("role") shouldBe "developer"
    deserialized.metadata should have size 3
  }

  it should "handle deeply nested structures" in {
    val order = Order(
      "ORD-12345",
      List(
        OrderItem("PROD-001", 2, BigDecimal("29.99")),
        OrderItem("PROD-002", 1, BigDecimal("49.99")),
        OrderItem("PROD-003", 5, BigDecimal("9.99"))
      ),
      BigDecimal("159.92"),
      Customer(
        "CUST-789",
        "Jane Smith",
        Some(Address("456 Oak Ave", "Boston", "02101"))
      )
    )

    val json = write(order)
    val deserialized = read[Order](json)

    deserialized.orderId shouldBe "ORD-12345"
    deserialized.items should have size 3
    deserialized.total shouldBe BigDecimal("159.92")
    deserialized.customer.name shouldBe "Jane Smith"
    deserialized.customer.address.get.city shouldBe "Boston"
  }

  it should "handle optional fields correctly" in {
    val customerWithAddress = Customer("C1", "Alice", Some(Address("123 Main", "NYC", "10001")))
    val customerWithoutAddress = Customer("C2", "Bob", None)

    val json1 = write(customerWithAddress)
    val json2 = write(customerWithoutAddress)

    val deserialized1 = read[Customer](json1)
    val deserialized2 = read[Customer](json2)

    deserialized1.address shouldBe defined
    deserialized1.address.get.city shouldBe "NYC"
    deserialized2.address shouldBe None
  }

  it should "preserve empty collections" in {
    val emptyLibrary = Library("Empty Library", List.empty, 0)
    val json = write(emptyLibrary)
    val deserialized = read[Library](json)

    deserialized.books shouldBe empty
    deserialized.capacity shouldBe 0
  }
}
