import com.codegik.parser.ExprParser

class ExprParserTest extends munit.FunSuite {

  def eval(s: String): Double = ExprParser.eval(s).getOrElse(throw AssertionError(s"Failed to parse: $s"))

  test("parses a single number") {
    assertEquals(eval("42"), 42.0)
  }

  test("parses a decimal number") {
    assertEquals(eval("3.14"), 3.14)
  }

  test("addition") {
    assertEquals(eval("1 + 2"), 3.0)
  }

  test("subtraction") {
    assertEquals(eval("10 - 4"), 6.0)
  }

  test("multiplication") {
    assertEquals(eval("3 * 4"), 12.0)
  }

  test("division") {
    assertEquals(eval("10 / 2"), 5.0)
  }

  test("operator precedence: * before +") {
    assertEquals(eval("2 + 3 * 4"), 14.0)
  }

  test("operator precedence: / before -") {
    assertEquals(eval("10 - 6 / 2"), 7.0)
  }

  test("parentheses override precedence") {
    assertEquals(eval("(2 + 3) * 4"), 20.0)
  }

  test("nested parentheses") {
    assertEquals(eval("((1 + 2) * (3 + 1))"), 12.0)
  }

  test("mixed operations") {
    assertEquals(eval("10 / 2 + 3 * 4 - 1"), 16.0)
  }

  test("returns Left on invalid input") {
    assert(ExprParser.eval("abc").isLeft)
  }
}
