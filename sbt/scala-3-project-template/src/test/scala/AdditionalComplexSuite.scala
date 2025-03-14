import munit.FunSuite
import scala.util.matching.Regex
import io.circe.parser._
import io.circe.Json

class AdditionalComplexSuite extends FunSuite {

  test("test with JSON parsing") {
    val jsonString = """{"name": "John", "age": 30}"""
    val json: Either[io.circe.ParsingFailure, Json] = parse(jsonString)
    json match {
      case Right(parsedJson) =>
        assertEquals(parsedJson.hcursor.get[String]("name").getOrElse(""), "John")
        assertEquals(parsedJson.hcursor.get[Int]("age").getOrElse(0), 30)
      case Left(failure) =>
        fail(s"Failed to parse JSON: ${failure.message}")
    }
  }

  test("test with regular expressions") {
    val pattern: Regex = "Scala (\\d+)".r
    val input = "Scala 3"
    input match {
      case pattern(version) => assertEquals(version, "3")
      case _ => fail("Regex did not match")
    }
  }

  test("test with custom assertion") {
    def assertPositive(value: Int): Unit = {
      assert(clue(value) > 0, s"Expected positive number, but got $value")
    }
    assertPositive(5)
    intercept[AssertionError] {
      assertPositive(-1)
    }
  }
}