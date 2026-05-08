package macros

import munit.FunSuite
import java.io.{ByteArrayOutputStream, PrintStream}

class SimpleExamplesTest extends FunSuite:

  private def capture(f: => Unit): String =
    val baos = new ByteArrayOutputStream()
    scala.Console.withOut(new PrintStream(baos))(f)
    baos.toString("UTF-8").trim

  // ── stringify ─────────────────────────────────────────────────────────────

  test("stringify — integer literal") {
    assertEquals(Simple.stringify(42), "42")
  }

  test("stringify — string literal") {
    // The macro sees the internal quoted form, so string literals are wrapped
    assert(Simple.stringify("hello").contains("hello"))
  }

  test("stringify — arithmetic expression") {
    val s = Simple.stringify(1 + 2 + 3)
    // Compiler may fold constants; either the expression or result is valid
    assert(s.nonEmpty)
  }

  test("stringify — method call") {
    val s = Simple.stringify(List(1, 2, 3).size)
    assert(s.nonEmpty)
  }

  test("stringify — does not evaluate the expression (zero side effects)") {
    var sideEffect = 0
    Simple.stringify({ sideEffect += 1; sideEffect })
    // stringifyImpl only calls expr.show at compile time and returns a String
    // constant — the expression itself is never spliced, so it never runs.
    assertEquals(sideEffect, 0)
  }

  // ── debug ─────────────────────────────────────────────────────────────────

  test("debug — returns value unchanged") {
    assertEquals(Simple.debug(21 * 2), 42)
    assertEquals(Simple.debug("hi"),   "hi")
    assertEquals(Simple.debug(true),   true)
  }

  test("debug — prints to stdout") {
    val out = capture { Simple.debug(99) }
    assert(out.nonEmpty)
    assert(out.contains("99"), s"Expected '99' in: $out")
  }

  test("debug — output contains the value") {
    val out = capture { Simple.debug(7 + 3) }
    assert(out.contains("10"), s"Expected value '10' in: $out")
  }

  test("debug — output contains '=' separator") {
    val out = capture { Simple.debug(0) }
    assert(out.contains("="), s"Expected '=' in: $out")
  }

  test("debug — works with strings") {
    val out = capture { Simple.debug("world") }
    assert(out.contains("world"), s"Expected 'world' in: $out")
  }

  test("debug — works with list expression") {
    val result = Simple.debug(List(1, 2, 3))
    assertEquals(result, List(1, 2, 3))
  }

  // ── twice ─────────────────────────────────────────────────────────────────

  test("twice — returns the last result") {
    assertEquals(Simple.twice(1 + 1), 2)
    assertEquals(Simple.twice("ok"),  "ok")
  }

  test("twice — runs the block exactly twice") {
    var count = 0
    Simple.twice { count += 1 }
    assertEquals(count, 2)
  }

  test("twice — side effects happen twice") {
    val buf = scala.collection.mutable.ListBuffer[Int]()
    Simple.twice { buf += 1 }
    assertEquals(buf.toList, List(1, 1))
  }

  test("twice — works with Unit blocks") {
    val out = capture { Simple.twice(println("ping")) }
    assertEquals(out, "ping\nping")
  }

  test("twice — works with effectful expressions") {
    var n = 0
    val result = Simple.twice { n += 10; n }
    assertEquals(result, 20)   // second evaluation: n = 20
    assertEquals(n, 20)
  }

  // ── isPrime ───────────────────────────────────────────────────────────────
  // Compile-time *rejection* cannot be tested at runtime — these tests verify
  // that valid prime literals compile and return the value unchanged.
  //
  // To see a compile-time failure, try:
  //   Simple.isPrime(4)   // error: 4 is not a prime number
  //   Simple.isPrime(1)   // error: 1 is not a prime number
  //   Simple.isPrime(0)   // error: 0 is not a prime number

  test("isPrime — 2 (smallest prime)") {
    assertEquals(Simple.isPrime(2), 2)
  }

  test("isPrime — 3") {
    assertEquals(Simple.isPrime(3), 3)
  }

  test("isPrime — 7") {
    assertEquals(Simple.isPrime(7), 7)
  }

  test("isPrime — 13") {
    assertEquals(Simple.isPrime(13), 13)
  }

  test("isPrime — 97 (prime near 100)") {
    assertEquals(Simple.isPrime(97), 97)
  }

  test("isPrime — 7919 (large prime)") {
    assertEquals(Simple.isPrime(7919), 7919)
  }

  // ── hex ───────────────────────────────────────────────────────────────────
  // To see a compile-time failure, try:
  //   Simple.hex("FF0000")    // error: missing '#'
  //   Simple.hex("#GG0000")   // error: invalid hex digit
  //   Simple.hex("#12345")    // error: wrong length

  test("hex — 3-digit shorthand") {
    assertEquals(Simple.hex("#F0A"), "#F0A")
    assertEquals(Simple.hex("#fff"), "#fff")
    assertEquals(Simple.hex("#000"), "#000")
  }

  test("hex — 6-digit full form") {
    assertEquals(Simple.hex("#FF0000"), "#FF0000")
    assertEquals(Simple.hex("#00ff00"), "#00ff00")
    assertEquals(Simple.hex("#1a2b3c"), "#1a2b3c")
  }

  test("hex — mixed case accepted") {
    assertEquals(Simple.hex("#aAbBcC"), "#aAbBcC")
  }

  test("hex — returns value unchanged") {
    val c = Simple.hex("#DEADBE")
    // Note: #DEADBE is 6 chars — valid
    assertEquals(c, "#DEADBE")
  }

  // ── printType ─────────────────────────────────────────────────────────────

  test("printType — primitive types") {
    assert(Simple.printType[Int].contains("Int"))
    assert(Simple.printType[Boolean].contains("Boolean"))
    assert(Simple.printType[Double].contains("Double"))
  }

  test("printType — String") {
    assert(Simple.printType[String].contains("String"))
  }

  test("printType — generic type includes type argument") {
    val t = Simple.printType[List[Int]]
    assert(t.contains("List"), s"Expected 'List' in: $t")
    assert(t.contains("Int"),  s"Expected 'Int' in: $t")
  }

  test("printType — Option[String]") {
    val t = Simple.printType[Option[String]]
    assert(t.contains("Option"), s"Expected 'Option' in: $t")
    assert(t.contains("String"), s"Expected 'String' in: $t")
  }

  test("printType — returns a compile-time constant (non-empty string)") {
    assert(Simple.printType[Any].nonEmpty)
    assert(Simple.printType[Nothing].nonEmpty)
    assert(Simple.printType[AnyVal].nonEmpty)
  }

  test("printType — nested generics") {
    val t = Simple.printType[Map[String, List[Int]]]
    assert(t.contains("Map"),    s"Expected 'Map' in: $t")
    assert(t.contains("String"), s"Expected 'String' in: $t")
    assert(t.contains("List"),   s"Expected 'List' in: $t")
    assert(t.contains("Int"),    s"Expected 'Int' in: $t")
  }
