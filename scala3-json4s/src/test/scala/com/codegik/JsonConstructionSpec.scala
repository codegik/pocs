package com.codegik

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.json4s._
import org.json4s.native.JsonMethods._

class JsonConstructionSpec extends AnyFlatSpec with Matchers {
  implicit val formats: Formats = DefaultFormats

  "Json4S construction" should "build complex JSON structures manually" in {
    val json = JObject(
      "user" -> JObject(
        "id" -> JInt(123),
        "profile" -> JObject(
          "name" -> JString("Alice"),
          "verified" -> JBool(true),
          "score" -> JDouble(95.5)
        ),
        "tags" -> JArray(List(
          JString("developer"),
          JString("scala"),
          JString("functional")
        ))
      )
    )

    (json \ "user" \ "id").extract[Int] shouldBe 123
    (json \ "user" \ "profile" \ "name").extract[String] shouldBe "Alice"
    (json \ "user" \ "profile" \ "verified").extract[Boolean] shouldBe true
    (json \ "user" \ "profile" \ "score").extract[Double] shouldBe 95.5
    (json \ "user" \ "tags").extract[List[String]] should have size 3
  }

  it should "construct arrays of objects" in {
    val json = JObject(
      "transactions" -> JArray(List(
        JObject(
          "id" -> JString("TXN-001"),
          "amount" -> JDouble(150.50),
          "status" -> JString("completed")
        ),
        JObject(
          "id" -> JString("TXN-002"),
          "amount" -> JDouble(75.25),
          "status" -> JString("pending")
        ),
        JObject(
          "id" -> JString("TXN-003"),
          "amount" -> JDouble(200.00),
          "status" -> JString("completed")
        )
      ))
    )

    val transactions = (json \ "transactions").children
    transactions should have size 3

    val completedTransactions = transactions.filter { txn =>
      (txn \ "status").extract[String] == "completed"
    }
    completedTransactions should have size 2
  }

  it should "handle null values" in {
    val json = JObject(
      "user" -> JObject(
        "name" -> JString("Bob"),
        "middleName" -> JNull,
        "age" -> JInt(30)
      )
    )

    (json \ "user" \ "name").extract[String] shouldBe "Bob"
    (json \ "user" \ "middleName").extractOpt[String] shouldBe None
    (json \ "user" \ "age").extract[Int] shouldBe 30
  }

  it should "create deeply nested structures" in {
    val json = JObject(
      "level1" -> JObject(
        "level2" -> JObject(
          "level3" -> JObject(
            "level4" -> JObject(
              "level5" -> JObject(
                "value" -> JString("deep")
              )
            )
          )
        )
      )
    )

    val deepValue = json \ "level1" \ "level2" \ "level3" \ "level4" \ "level5" \ "value"
    deepValue.extract[String] shouldBe "deep"
  }

  it should "combine multiple JSON objects" in {
    val header = JObject("version" -> JString("1.0"), "timestamp" -> JInt(1234567890))
    val body = JObject("data" -> JString("payload"), "encrypted" -> JBool(false))
    val footer = JObject("signature" -> JString("abc123"))

    val complete = JObject(
      "header" -> header,
      "body" -> body,
      "footer" -> footer
    )

    (complete \ "header" \ "version").extract[String] shouldBe "1.0"
    (complete \ "body" \ "data").extract[String] shouldBe "payload"
    (complete \ "footer" \ "signature").extract[String] shouldBe "abc123"
  }

  it should "create mixed type arrays" in {
    val json = JObject(
      "mixed" -> JArray(List(
        JInt(42),
        JString("text"),
        JBool(true),
        JDouble(3.14),
        JObject("nested" -> JString("value"))
      ))
    )

    val array = (json \ "mixed").children
    array should have size 5
    array.head.extract[Int] shouldBe 42
    array(1).extract[String] shouldBe "text"
    array(2).extract[Boolean] shouldBe true
  }

  it should "build JSON from conditional logic" in {
    def buildUserJson(userId: Int, includeSensitive: Boolean): JValue = {
      val base = JObject(
        "id" -> JInt(userId),
        "username" -> JString(s"user$userId")
      )

      if (includeSensitive) {
        base merge JObject(
          "email" -> JString(s"user$userId@test.com"),
          "phone" -> JString("555-0000")
        )
      } else {
        base
      }
    }

    val publicJson = buildUserJson(123, includeSensitive = false)
    val privateJson = buildUserJson(123, includeSensitive = true)

    (publicJson \ "id").extract[Int] shouldBe 123
    (publicJson \ "email").toOption shouldBe None

    (privateJson \ "id").extract[Int] shouldBe 123
    (privateJson \ "email").extract[String] shouldBe "user123@test.com"
  }
}
