import com.codegik.parser.Parser
import com.codegik.parser.ParseResult
import com.codegik.parser.ParseResult.*

class ParserTest extends munit.FunSuite:

  test("char: succeeds on matching character"):
    val result = Parser.char('a').parse("abc")
    assertEquals(result, Success('a', "bc"))

  test("char: fails on non-matching character"):
    assert(!Parser.char('x').parse("abc").isSuccess)

  test("string: succeeds on matching prefix"):
    val result = Parser.string("hello").parse("hello world")
    assertEquals(result, Success("hello", " world"))

  test("string: fails on non-matching input"):
    assert(!Parser.string("foo").parse("bar").isSuccess)

  test("digit: parses a digit"):
    assertEquals(Parser.digit.parse("3abc"), Success('3', "abc"))

  test("many: parses zero or more"):
    assertEquals(Parser.digit.many.parse("123abc"), Success(List('1','2','3'), "abc"))
    assertEquals(Parser.digit.many.parse("abc"), Success(List.empty, "abc"))

  test("many1: requires at least one"):
    assert(Parser.digit.many1.parse("abc").isSuccess == false)
    assert(Parser.digit.many1.parse("1abc").isSuccess)

  test("or: tries alternative on failure"):
    val p = Parser.char('a') or Parser.char('b')
    assertEquals(p.parse("abc"), Success('a', "bc"))
    assertEquals(p.parse("bcd"), Success('b', "cd"))
    assert(!p.parse("xyz").isSuccess)

  test("map: transforms parsed value"):
    val p = Parser.digit.map(_.asDigit)
    assertEquals(p.parse("5rest"), Success(5, "rest"))

  test("flatMap: sequences parsers"):
    val p = Parser.char('a').flatMap(_ => Parser.char('b'))
    assertEquals(p.parse("abc"), Success('b', "c"))

  test("~ operator: keeps both results"):
    val p = Parser.char('a') ~ Parser.char('b')
    assertEquals(p.parse("abc"), Success(('a', 'b'), "c"))

  test("<~ operator: keeps left result"):
    val p = Parser.char('a') <~ Parser.char('b')
    assertEquals(p.parse("abc"), Success('a', "c"))

  test("~> operator: keeps right result"):
    val p = Parser.char('a') ~> Parser.char('b')
    assertEquals(p.parse("abc"), Success('b', "c"))

  test("opt: returns Some on success, None on failure"):
    val p = Parser.char('a').opt
    assertEquals(p.parse("abc"), Success(Some('a'), "bc"))
    assertEquals(p.parse("xyz"), Success(None, "xyz"))

  test("sepBy: parses comma-separated digits"):
    val p = Parser.digit.sepBy(Parser.char(','))
    assertEquals(p.parse("1,2,3"), Success(List('1','2','3'), ""))

  test("between: parses content between delimiters"):
    val p = Parser.digit.between(Parser.char('('), Parser.char(')'))
    assertEquals(p.parse("(5)rest"), Success('5', "rest"))

  test("whitespace: skips spaces"):
    val p = Parser.token(Parser.char('x'))
    assertEquals(p.parse("  x  "), Success('x', ""))

  test("choice: first match wins"):
    val p = Parser.choice(Parser.string("foo"), Parser.string("bar"), Parser.string("baz"))
    assertEquals(p.parse("bar"), Success("bar", ""))
