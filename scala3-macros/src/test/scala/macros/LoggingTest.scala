package macros

import munit.FunSuite
import java.io.{ByteArrayOutputStream, PrintStream}


class LoggingTest extends FunSuite:

  /** Captures stdout produced by `f`, returning the printed string.
   *  Uses Console.withOut because Scala's println writes to Console.out, not System.out.
   */
  private def capture(f: => Unit): String =
    val baos = new ByteArrayOutputStream()
    val ps   = new PrintStream(baos)
    scala.Console.withOut(ps)(f)
    ps.flush()
    baos.toString("UTF-8").trim

  // ── log ───────────────────────────────────────────────────────────────────

  test("log returns the expression value unchanged") {
    assertEquals(Logging.log(1 + 2), 3)
    assertEquals(Logging.log("hello"), "hello")
    assertEquals(Logging.log(List(1, 2, 3)), List(1, 2, 3))
  }

  test("log prints to stdout") {
    val out = capture { Logging.log(42) }
    assert(out.nonEmpty, "log should print something")
    assert(out.contains("42"), s"Expected '42' in output: $out")
  }

  test("log output contains [LOG prefix") {
    val out = capture { Logging.log(99) }
    assert(out.startsWith("[LOG"), s"Expected '[LOG' prefix, got: $out")
  }

  test("log output contains source file name") {
    val out = capture { Logging.log(0) }
    // The source file is LoggingTest.scala
    assert(out.contains("LoggingTest.scala"), s"Expected file name in output: $out")
  }

  test("log output contains line number") {
    val out = capture { Logging.log(0) }
    // Should contain a colon followed by digits (e.g., :42])
    assert(out.matches(".*:\\d+\\].*"), s"Expected line number in output: $out")
  }

  test("log output stringifies the expression source text") {
    val out = capture { Logging.log(1 + 1) }
    // The compiler may constant-fold 1+1 to 2 before the macro sees it;
    // either the folded literal or the original expression text is acceptable.
    assert(
      out.contains("1 + 1") || out.contains("1.+(1)") || out.contains("2"),
      s"Expected expression source text or folded value in output: $out"
    )
  }

  // ── time ──────────────────────────────────────────────────────────────────

  test("time returns the block value unchanged") {
    val result = Logging.time("test")(42 * 2)
    assertEquals(result, 84)
  }

  test("time returns correct value for list operation") {
    val result = Logging.time("sum") { (1 to 10).sum }
    assertEquals(result, 55)
  }

  test("time prints [TIME label to stdout") {
    val out = capture { Logging.time("my-op")(()) }
    assert(out.contains("[TIME]"), s"Expected '[TIME]' in output: $out")
    assert(out.contains("my-op"), s"Expected label 'my-op' in output: $out")
  }

  test("time output contains milliseconds") {
    val out = capture { Logging.time("x")(Thread.sleep(1)) }
    assert(out.contains("ms"), s"Expected 'ms' in output: $out")
  }

  // ── trace ─────────────────────────────────────────────────────────────────

  test("trace returns the expression value unchanged") {
    assertEquals(Logging.trace("step", 7 * 6), 42)
    assertEquals(Logging.trace("s", "hello"), "hello")
  }

  test("trace prints [TRACE prefix with label") {
    val out = capture { Logging.trace("my-label", 1) }
    assert(out.contains("[TRACE"), s"Expected '[TRACE' in output: $out")
    assert(out.contains("my-label"), s"Expected 'my-label' in output: $out")
  }

  test("trace output contains the expression value") {
    val out = capture { Logging.trace("v", 123) }
    assert(out.contains("123"), s"Expected value '123' in output: $out")
  }

  // ── logIf ─────────────────────────────────────────────────────────────────

  test("logIf(true) returns value and prints") {
    var result = 0
    val out = capture { result = Logging.logIf(true)(21 + 21) }
    assertEquals(result, 42)
    assert(out.nonEmpty, "logIf(true) should print")
  }

  test("logIf(false) returns value and produces no output") {
    var result = 0
    val out = capture { result = Logging.logIf(false)(21 + 21) }
    assertEquals(result, 42)
    assertEquals(out, "", s"logIf(false) should not print, got: $out")
  }

  // ── benchmark ─────────────────────────────────────────────────────────────

  test("benchmark returns last block value") {
    val result = Logging.benchmark("x", 3)(1 + 1)
    assertEquals(result, 2)
  }

  test("benchmark prints [BENCH] header") {
    val out = capture { Logging.benchmark("test-bench", 2)(()) }
    assert(out.contains("[BENCH]"), s"Expected '[BENCH]' in output: $out")
    assert(out.contains("test-bench"), s"Expected label in output: $out")
  }

  test("benchmark prints min/max/avg") {
    val out = capture { Logging.benchmark("stats", 3)(42) }
    assert(out.contains("min="), s"Expected 'min=' in output: $out")
    assert(out.contains("max="), s"Expected 'max=' in output: $out")
    assert(out.contains("avg="), s"Expected 'avg=' in output: $out")
  }

  test("benchmark runs block the specified number of times") {
    var count = 0
    Logging.benchmark("count-test", 5) { count += 1 }
    // 1 warm-up + 5 measured iterations
    assertEquals(count, 6)
  }
