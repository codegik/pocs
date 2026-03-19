import com.codegik.parser.JsonParser
import com.codegik.parser.Json.*
import com.codegik.parser.ParseResult.Success

class JsonParserTest extends munit.FunSuite:

  def parse(s: String) = JsonParser.parse(s) match
    case Success(v, _) => v
    case f             => throw AssertionError(s"Parse failed: $f")

  test("parses null"):
    assertEquals(parse("null"), JNull)

  test("parses true"):
    assertEquals(parse("true"), JBool(true))

  test("parses false"):
    assertEquals(parse("false"), JBool(false))

  test("parses integer"):
    assertEquals(parse("42"), JNumber(42.0))

  test("parses negative number"):
    assertEquals(parse("-7"), JNumber(-7.0))

  test("parses decimal"):
    assertEquals(parse("3.14"), JNumber(3.14))

  test("parses string"):
    assertEquals(parse(""""hello""""), JString("hello"))

  test("parses empty string"):
    assertEquals(parse(""""""""), JString(""))

  test("parses array of numbers"):
    assertEquals(parse("[1, 2, 3]"), JArray(List(JNumber(1), JNumber(2), JNumber(3))))

  test("parses empty array"):
    assertEquals(parse("[]"), JArray(Nil))

  test("parses nested array"):
    assertEquals(parse("[[1, 2], [3]]"), JArray(List(JArray(List(JNumber(1), JNumber(2))), JArray(List(JNumber(3))))))

  test("parses object"):
    assertEquals(parse("""{"a": 1}"""), JObject(Map("a" -> JNumber(1))))

  test("parses empty object"):
    assertEquals(parse("{}"), JObject(Map.empty))

  test("parses object with multiple fields"):
    val result = parse("""{"name": "Alice", "age": 30, "active": true}""")
    assertEquals(result, JObject(Map("name" -> JString("Alice"), "age" -> JNumber(30), "active" -> JBool(true))))

  test("parses nested object"):
    val result = parse("""{"user": {"id": 1, "tags": ["admin", "user"]}}""")
    assertEquals(result, JObject(Map("user" -> JObject(Map("id" -> JNumber(1), "tags" -> JArray(List(JString("admin"), JString("user"))))))))
