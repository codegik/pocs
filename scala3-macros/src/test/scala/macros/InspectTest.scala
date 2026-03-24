package macros

import munit.FunSuite

case class Rect(width: Int, height: Int)
case class Book(title: String, author: String, pages: Int, price: Double)
case class Config(host: String, port: Int, debug: Boolean, tag: Option[String])

given Show[Rect]   = Show.derived[Rect]
given Show[Book]   = Show.derived[Book]
given Show[Config] = Show.derived[Config]

class InspectTest extends FunSuite:

  // ── fieldNames ────────────────────────────────────────────────────────────

  test("fieldNames[Rect]") {
    assertEquals(Inspect.fieldNames[Rect], List("width", "height"))
  }

  test("fieldNames[Book]") {
    assertEquals(Inspect.fieldNames[Book], List("title", "author", "pages", "price"))
  }

  test("fieldNames[Config]") {
    assertEquals(Inspect.fieldNames[Config], List("host", "port", "debug", "tag"))
  }

  // ── fieldCount ────────────────────────────────────────────────────────────

  test("fieldCount[Rect] == 2") {
    assertEquals(Inspect.fieldCount[Rect], 2)
  }

  test("fieldCount[Book] == 4") {
    assertEquals(Inspect.fieldCount[Book], 4)
  }

  // ── fieldTypes ────────────────────────────────────────────────────────────

  test("fieldTypes[Rect] returns (name, typeName) pairs") {
    val types = Inspect.fieldTypes[Rect]
    assertEquals(types.map(_._1), List("width", "height"))
    assert(types.forall(_._2.contains("Int")))
  }

  test("fieldTypes[Book] includes all field types") {
    val types = Inspect.fieldTypes[Book].toMap
    assert(types("title").contains("String"))
    assert(types("pages").contains("Int"))
    assert(types("price").contains("Double"))
  }

  test("fieldTypes[Config] reflects Option field") {
    val types = Inspect.fieldTypes[Config].toMap
    assert(types("tag").contains("Option"), s"Expected Option in '${types("tag")}'")
  }

  // ── toMap ─────────────────────────────────────────────────────────────────

  test("toMap[Rect] produces correct map") {
    val m = Inspect.toMap(Rect(10, 20))
    assertEquals(m("width"),  10)
    assertEquals(m("height"), 20)
  }

  test("toMap[Book] preserves all values") {
    val book = Book("Scala 3", "EPFL", 400, 49.99)
    val m    = Inspect.toMap(book)
    assertEquals(m("title"),  "Scala 3")
    assertEquals(m("author"), "EPFL")
    assertEquals(m("pages"),  400)
    assertEquals(m("price"),  49.99)
  }

  test("toMap[Config] with Option field") {
    val c1 = Config("localhost", 8080, true, Some("dev"))
    val c2 = Config("prod.host", 443,  false, None)
    assertEquals(Inspect.toMap(c1)("tag"), Some("dev"))
    assertEquals(Inspect.toMap(c2)("tag"), None)
  }

  test("toMap keys match fieldNames") {
    val m = Inspect.toMap(Book("X", "Y", 1, 1.0))
    assertEquals(m.keySet.toList.sorted, Inspect.fieldNames[Book].sorted)
  }

  // ── toJson ────────────────────────────────────────────────────────────────

  test("toJson[Rect] produces valid JSON-like string") {
    val json = Inspect.toJson(Rect(3, 7))
    assert(json.startsWith("{"))
    assert(json.endsWith("}"))
    assert(json.contains("\"width\": 3"))
    assert(json.contains("\"height\": 7"))
  }

  test("toJson[Config] handles Option — Some") {
    val json = Inspect.toJson(Config("localhost", 9000, true, Some("test")))
    assert(json.contains("\"host\": \"localhost\""))
    assert(json.contains("\"port\": 9000"))
    assert(json.contains("\"debug\": true"))
    assert(json.contains("\"tag\": \"test\""))
  }

  test("toJson[Config] handles Option — None") {
    val json = Inspect.toJson(Config("host", 80, false, None))
    assert(json.contains("\"tag\": null"))
  }

  test("toJson[Book] quotes string fields") {
    val json = Inspect.toJson(Book("Clean Code", "Martin", 431, 35.0))
    assert(json.contains("\"title\": \"Clean Code\""))
    assert(json.contains("\"author\": \"Martin\""))
  }

  // ── isCaseClass ───────────────────────────────────────────────────────────

  test("isCaseClass[Rect] is true") {
    assert(Inspect.isCaseClass[Rect])
  }

  test("isCaseClass[String] is false") {
    assert(!Inspect.isCaseClass[String])
  }

  test("isCaseClass[Int] is false") {
    assert(!Inspect.isCaseClass[Int])
  }

  // ── requireSubtype (compile-time, tested by the fact it compiles) ─────────

  test("requireSubtype compiles for valid subtypes") {
    // If these lines compile, the subtype check passed at compile time.
    Inspect.requireSubtype[Int, AnyVal]
    Inspect.requireSubtype[String, AnyRef]
    Inspect.requireSubtype[Nothing, Int]
  }
