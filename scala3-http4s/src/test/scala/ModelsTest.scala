package com.codegik.http4s

import io.circe.parser.decode
import io.circe.syntax.*
import munit.FunSuite

class ModelsTest extends FunSuite:

  test("User round-trips through JSON") {
    val user = User(1L, "Alice", "alice@example.com", 30)
    val json = user.asJson.noSpaces
    assertEquals(decode[User](json), Right(user))
  }

  test("User encodes the expected JSON shape") {
    val json = User(7L, "Bob", "bob@example.com", 25).asJson
    assertEquals(json.hcursor.get[Long]("id"), Right(7L))
    assertEquals(json.hcursor.get[String]("name"), Right("Bob"))
    assertEquals(json.hcursor.get[String]("email"), Right("bob@example.com"))
    assertEquals(json.hcursor.get[Int]("age"), Right(25))
  }

  test("UserInput decodes from JSON without an id") {
    val json = """{"name":"Carol","email":"carol@example.com","age":40}"""
    assertEquals(decode[UserInput](json), Right(UserInput("Carol", "carol@example.com", 40)))
  }

  test("UserInput decoding fails when a field is missing") {
    val json = """{"name":"Carol","email":"carol@example.com"}"""
    assert(decode[UserInput](json).isLeft)
  }

  test("valid UserInput produces no validation errors") {
    assertEquals(UserInput("Alice", "alice@example.com", 30).validate, Nil)
  }

  test("blank name is rejected") {
    assert(UserInput("  ", "a@example.com", 30).validate.contains("name must not be blank"))
  }

  test("email without @ is rejected") {
    assert(UserInput("Alice", "invalid", 30).validate.exists(_.contains("email")))
  }

  test("negative age is rejected") {
    assert(UserInput("Alice", "a@example.com", -1).validate.exists(_.contains("age")))
  }

  test("age above 150 is rejected") {
    assert(UserInput("Alice", "a@example.com", 200).validate.exists(_.contains("age")))
  }

  test("multiple problems are reported together") {
    assertEquals(UserInput("", "invalid", -5).validate.size, 3)
  }

  test("ApiError single-string apply wraps into a list") {
    assertEquals(ApiError("boom").errors, List("boom"))
  }

  test("ApiError round-trips through JSON") {
    val err = ApiError(List("a", "b"))
    assertEquals(decode[ApiError](err.asJson.noSpaces), Right(err))
  }
