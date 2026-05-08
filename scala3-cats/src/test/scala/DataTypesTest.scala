import cats.data.*
import cats.implicits.*
import cats_poc.*

class DataTypesTest extends munit.FunSuite:

  // ── NonEmptyList ──────────────────────────────────────────────────────────

  test("NonEmptyList head returns first element"):
    val nel = NonEmptyList.of(1, 2, 3)
    assertEquals(NonEmptyLists.head(nel), 1)

  test("NonEmptyList append adds element at end"):
    val nel    = NonEmptyList.of(1, 2)
    val result = NonEmptyLists.append(nel, 3)
    assertEquals(result.toList, List(1, 2, 3))

  test("fromList returns Some for non-empty list"):
    assertEquals(NonEmptyLists.fromList(List(1, 2, 3)), Some(NonEmptyList.of(1, 2, 3)))

  test("fromList returns None for empty list"):
    assertEquals(NonEmptyLists.fromList(List.empty[Int]), None)

  // ── EitherT ───────────────────────────────────────────────────────────────

  test("EitherT finds adult user"):
    val result = EitherTransformer.getAdultUser(1)
    assertEquals(result.value, Some(Right(User(1, "Alice", 30))))

  test("EitherT rejects underage user"):
    val result = EitherTransformer.getAdultUser(2)
    assertEquals(result.value, Some(Left("Bob is underage")))
    // Bob's age is 15, below the 18 threshold

  test("EitherT handles missing user"):
    val result = EitherTransformer.getAdultUser(99)
    assertEquals(result.value, Some(Left("User 99 not found")))

  // ── OptionT ───────────────────────────────────────────────────────────────

  test("resolve returns Right(Some) for known id"):
    assertEquals(OptionTransformer.resolve("1"), Right(Some("alpha")))

  test("resolve returns Right(None) for unknown id"):
    assertEquals(OptionTransformer.resolve("99"), Right(None))

  test("resolve returns Left for non-integer input"):
    assertEquals(OptionTransformer.resolve("abc"), Left("'abc' is not a valid integer"))

  // ── Writer ────────────────────────────────────────────────────────────────

  test("Writer factorial computes correct result"):
    val (_, result) = Writers.factorial(5).run
    assertEquals(result, 120)

  test("Writer factorial accumulates logs"):
    val (logs, _) = Writers.factorial(3).run
    assert(logs.nonEmpty)
    assert(logs.exists(_.contains("base case")))

  test("Writer factorial of 1 returns base case"):
    val (logs, result) = Writers.factorial(1).run
    assertEquals(result, 1)
    assertEquals(logs, List("base case: 1"))

  // ── State ─────────────────────────────────────────────────────────────────

  test("State program pops all pushed values in LIFO order"):
    val (_, pops) = States.program(List(1, 2, 3)).run(Nil).value
    assertEquals(pops, List(Some(3), Some(2), Some(1)))

  test("State program leaves empty stack after all pops"):
    val (stack, _) = States.program(List(10, 20)).run(Nil).value
    assertEquals(stack, Nil)

  test("State pop on empty stack returns None"):
    val (_, result) = States.pop.run(Nil).value
    assertEquals(result, None)
