package com.codegik

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.json4s._
import org.json4s.native.JsonMethods._

class JsonParsingSpec extends AnyFlatSpec with Matchers {
  implicit val formats: Formats = DefaultFormats

  "Json4S parsing" should "extract values from nested JSON" in {
    val jsonString = """
    {
      "company": {
        "name": "TechCorp",
        "departments": [
          {
            "name": "Engineering",
            "employees": 50
          },
          {
            "name": "Sales",
            "employees": 30
          }
        ]
      }
    }
    """

    val json = parse(jsonString)

    (json \ "company" \ "name").extract[String] shouldBe "TechCorp"
    (json \ "company" \ "departments" \ "name").extract[List[String]] should contain allOf ("Engineering", "Sales")
    ((json \ "company" \ "departments")(0) \ "employees").extract[Int] shouldBe 50
  }

  it should "handle array operations" in {
    val jsonString = """
    {
      "products": [
        {"id": 1, "name": "Laptop", "price": 999.99},
        {"id": 2, "name": "Mouse", "price": 29.99},
        {"id": 3, "name": "Keyboard", "price": 79.99}
      ]
    }
    """

    val json = parse(jsonString)
    val products = (json \ "products").children

    products should have size 3
    (products.head \ "name").extract[String] shouldBe "Laptop"
    (products(2) \ "price").extract[Double] shouldBe 79.99
  }

  it should "extract optional values safely" in {
    val jsonString = """
    {
      "user": {
        "name": "Alice",
        "age": 30
      }
    }
    """

    val json = parse(jsonString)

    (json \ "user" \ "name").extractOpt[String] shouldBe Some("Alice")
    (json \ "user" \ "email").extractOpt[String] shouldBe None
    (json \ "user" \ "age").extractOpt[Int] shouldBe Some(30)
    (json \ "nonexistent").extractOpt[String] shouldBe None
  }

  it should "transform JSON structures" in {
    val original = parse("""{"firstName": "John", "lastName": "Doe", "age": 30}""")

    val transformed = original.transformField {
      case ("firstName", JString(s)) => ("name", JString(s))
      case ("age", JInt(n)) => ("yearsOld", JInt(n))
    }

    (transformed \ "name").extract[String] shouldBe "John"
    (transformed \ "yearsOld").extract[Int] shouldBe 30
    (transformed \ "firstName").toOption shouldBe None
  }

  it should "merge JSON objects" in {
    val json1 = parse("""{"name": "Alice", "age": 25}""")
    val json2 = parse("""{"email": "alice@test.com", "city": "NYC"}""")

    val merged = json1 merge json2

    (merged \ "name").extract[String] shouldBe "Alice"
    (merged \ "age").extract[Int] shouldBe 25
    (merged \ "email").extract[String] shouldBe "alice@test.com"
    (merged \ "city").extract[String] shouldBe "NYC"
  }

  it should "handle deep merging with conflicts" in {
    val json1 = parse("""{"user": {"name": "Alice", "age": 25}}""")
    val json2 = parse("""{"user": {"age": 26, "email": "alice@test.com"}}""")

    val merged = json1 merge json2

    (merged \ "user" \ "name").extract[String] shouldBe "Alice"
    (merged \ "user" \ "age").extract[Int] shouldBe 26
    (merged \ "user" \ "email").extract[String] shouldBe "alice@test.com"
  }

  it should "filter JSON arrays" in {
    val jsonString = """
    {
      "items": [
        {"name": "item1", "active": true, "price": 10},
        {"name": "item2", "active": false, "price": 20},
        {"name": "item3", "active": true, "price": 30}
      ]
    }
    """

    val json = parse(jsonString)
    val items = (json \ "items").children

    val activeItems = items.filter { item =>
      (item \ "active").extract[Boolean]
    }

    activeItems should have size 2
    (activeItems.head \ "name").extract[String] shouldBe "item1"
    (activeItems(1) \ "price").extract[Int] shouldBe 30
  }

  it should "handle complex path extraction" in {
    val jsonString = """
    {
      "data": {
        "users": [
          {
            "id": 1,
            "profile": {
              "personal": {
                "name": "Alice",
                "contacts": {
                  "email": "alice@test.com",
                  "phone": "555-1234"
                }
              }
            }
          }
        ]
      }
    }
    """

    val json = parse(jsonString)

    val email = (json \ "data" \ "users")(0) \ "profile" \ "personal" \ "contacts" \ "email"
    email.extract[String] shouldBe "alice@test.com"
  }
}
