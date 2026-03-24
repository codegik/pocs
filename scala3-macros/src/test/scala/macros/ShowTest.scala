package macros

import munit.FunSuite

// Derive Show instances for the test models via macro
case class Point(x: Int, y: Int)
case class Color(name: String, hex: String)
case class Circle(center: Point, radius: Double, color: Color)
case object Origin

given Show[Point]  = Show.derived[Point]
given Show[Color]  = Show.derived[Color]
given Show[Circle] = Show.derived[Circle]
given Show[Origin.type] = Show.derived[Origin.type]

class ShowTest extends FunSuite:

  // ── primitives ────────────────────────────────────────────────────────────

  test("Show[Int]") {
    assertEquals(summon[Show[Int]].show(42), "42")
    assertEquals(summon[Show[Int]].show(-1), "-1")
  }

  test("Show[String] wraps value in quotes") {
    assertEquals(summon[Show[String]].show("hello"), "\"hello\"")
  }

  test("Show[Boolean]") {
    assertEquals(summon[Show[Boolean]].show(true), "true")
    assertEquals(summon[Show[Boolean]].show(false), "false")
  }

  test("Show[Double]") {
    assertEquals(summon[Show[Double]].show(3.14), "3.14")
  }

  // ── collections ──────────────────────────────────────────────────────────

  test("Show[Option[Int]] — None") {
    assertEquals(summon[Show[Option[Int]]].show(None), "None")
  }

  test("Show[Option[Int]] — Some") {
    assertEquals(summon[Show[Option[Int]]].show(Some(7)), "Some(7)")
  }

  test("Show[List[Int]]") {
    assertEquals(summon[Show[List[Int]]].show(List(1, 2, 3)), "List(1, 2, 3)")
    assertEquals(summon[Show[List[Int]]].show(Nil), "List()")
  }

  test("Show[(Int, String)]") {
    assertEquals(summon[Show[(Int, String)]].show((1, "a")), "(1, \"a\")")
  }

  // ── macro-derived case classes ────────────────────────────────────────────

  test("derived Show[Point] renders field names and values") {
    val p = Point(3, 4)
    assertEquals(p.show, "Point(x = 3, y = 4)")
  }

  test("derived Show[Color]") {
    val c = Color("red", "#FF0000")
    assertEquals(c.show, """Color(name = "red", hex = "#FF0000")""")
  }

  test("derived Show[Circle] — nested case classes") {
    val c = Circle(Point(0, 0), 5.0, Color("blue", "#0000FF"))
    assertEquals(
      c.show,
      """Circle(center = Point(x = 0, y = 0), radius = 5.0, color = Color(name = "blue", hex = "#0000FF"))"""
    )
  }

  test("derived Show[Origin.type] — case object") {
    assertEquals(Origin.show, "Origin")
  }

  // ── extension method ──────────────────────────────────────────────────────

  test("extension .show delegates to Show instance") {
    val p: Point = Point(1, 2)
    assertEquals(p.show, summon[Show[Point]].show(p))
  }

  // ── Show[Option[T]] with derived T ───────────────────────────────────────

  test("Show[Option[Point]] composes correctly") {
    assertEquals(Option(Point(1, 1)).show, "Some(Point(x = 1, y = 1))")
    assertEquals((None: Option[Point]).show, "None")
  }

  test("Show[List[Point]] composes correctly") {
    assertEquals(List(Point(0, 0), Point(1, 2)).show,
      "List(Point(x = 0, y = 0), Point(x = 1, y = 2))")
  }
