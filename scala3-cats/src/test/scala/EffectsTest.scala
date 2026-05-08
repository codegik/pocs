import cats.effect.*
import cats.implicits.*
import cats_poc.*
import munit.CatsEffectSuite

class EffectsTest extends CatsEffectSuite:

  // ── IO basics ─────────────────────────────────────────────────────────────

  test("helloIO returns 'hello'"):
    IOExamples.helloIO.map(assertEquals(_, "hello"))

  test("delayed doubles the value"):
    IOExamples.delayed(6).map(assertEquals(_, 12))

  test("pipeline adds then doubles"):
    IOExamples.pipeline(3, 4).map(assertEquals(_, 14))

  // ── Error handling ────────────────────────────────────────────────────────

  test("safeDivide returns result when divisor is non-zero"):
    IOErrors.safeDivide(10, 2).map(assertEquals(_, 5))

  test("safeDivide raises error on division by zero"):
    IOErrors.safeDivide(10, 0).attempt.map { result =>
      assert(result.isLeft)
      assert(result.left.exists(_.isInstanceOf[ArithmeticException]))
    }

  test("withFallback returns -1 on division by zero"):
    IOErrors.withFallback(10, 0).map(assertEquals(_, -1))

  test("withFallback returns correct result on valid division"):
    IOErrors.withFallback(20, 4).map(assertEquals(_, 5))

  test("attempt returns Right on success"):
    IOErrors.attempt(8, 4).map { result =>
      assertEquals(result, Right(2))
    }

  test("attempt returns Left on failure"):
    IOErrors.attempt(8, 0).map { result =>
      assert(result.isLeft)
    }

  // ── Parallel execution ────────────────────────────────────────────────────

  test("parTraverse multiplies each value by 3"):
    IOParallel.tasks(List(1, 2, 3, 4)).map(assertEquals(_, List(3, 6, 9, 12)))

  test("parTraverse on empty list returns empty list"):
    IOParallel.tasks(List.empty).map(assertEquals(_, List.empty[Int]))

  test("parTupled returns both results"):
    IOParallel.bothResults.map(assertEquals(_, ("hello", 42)))

  // ── Resource management ───────────────────────────────────────────────────

  test("Resource executes query and releases connection"):
    Resources.runQuery(1, "SELECT 1").map { result =>
      assert(result.contains("result of"))
      assert(result.contains("conn#1"))
    }
