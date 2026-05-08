import cats.*
import cats.implicits.*
import cats_poc.*
import cats_poc.UserInstances.given

class TypeclassesTest extends munit.FunSuite:

  // ── Functor ──────────────────────────────────────────────────────────────

  test("Functor doubles each element in a List"):
    assertEquals(Functors.doubleInside(List(1, 2, 3)), List(2, 4, 6))

  test("Functor doubles the value inside Option"):
    assertEquals(Functors.doubleInside(Option(5)), Option(10))

  test("Functor on None stays None"):
    assertEquals(Functors.doubleInside(Option.empty[Int]), Option.empty[Int])

  // ── Applicative ──────────────────────────────────────────────────────────

  test("pureValue wraps value in List"):
    assertEquals(Functors.pureValue[List](42), List(42))

  test("pureValue wraps value in Option"):
    assertEquals(Functors.pureValue[Option](7), Some(7))

  test("combineEffects sums two Options"):
    assertEquals(Functors.combineEffects(Option(3), Option(4)), Option(7))

  test("combineEffects returns None if any operand is None"):
    assertEquals(Functors.combineEffects(Option(3), Option.empty[Int]), Option.empty[Int])

  // ── Monoid ───────────────────────────────────────────────────────────────

  test("combine concatenates strings"):
    assertEquals(Monoids.combine("hello ", "world"), "hello world")

  test("combine sums integers"):
    assertEquals(Monoids.combine(10, 32), 42)

  test("sumAll adds a list of ints"):
    assertEquals(Monoids.sumAll(List(1, 2, 3, 4, 5)), 15)

  test("sumAll on empty list returns Monoid zero"):
    assertEquals(Monoids.sumAll(List.empty[Int]), 0)

  test("sumAll concatenates list of strings"):
    assertEquals(Monoids.sumAll(List("a", "b", "c")), "abc")

  // ── Eq ───────────────────────────────────────────────────────────────────

  test("Eq compares users by id"):
    val u1 = User(1, "Alice", 30)
    val u2 = User(1, "Different Name", 99)
    assert(UserInstances.given_Eq_User.eqv(u1, u2))

  test("Eq distinguishes users with different ids"):
    val u1 = User(1, "Alice", 30)
    val u2 = User(2, "Alice", 30)
    assert(UserInstances.given_Eq_User.neqv(u1, u2))

  // ── Order ─────────────────────────────────────────────────────────────────

  test("Order sorts users by age"):
    val users = List(User(1, "Alice", 30), User(2, "Bob", 25), User(3, "Carol", 35))
    assertEquals(users.sorted, List(User(2, "Bob", 25), User(1, "Alice", 30), User(3, "Carol", 35)))

  // ── Show ─────────────────────────────────────────────────────────────────

  test("Show renders user as expected string"):
    val user = User(1, "Alice", 30)
    assertEquals(user.show, "User(1, Alice, age=30)")

  // ── Validated ────────────────────────────────────────────────────────────

  test("validateUser succeeds with valid inputs"):
    val result = Validation.validateUser("Alice", 30)
    assert(result.isValid)
    assertEquals(result.toOption.map(_.name), Some("Alice"))

  test("validateUser accumulates errors for empty name and invalid age"):
    val result = Validation.validateUser("", -5)
    assert(result.isInvalid)
    assertEquals(result.fold(identity, _ => Nil).size, 2)

  test("validateUser fails for empty name only"):
    val result = Validation.validateUser("", 25)
    assert(result.isInvalid)
    assertEquals(result.fold(identity, _ => Nil), List("Name must not be empty"))

  test("validateUser fails for invalid age only"):
    val result = Validation.validateUser("Bob", 200)
    assert(result.isInvalid)

  // ── Option / Either chaining ──────────────────────────────────────────────

  test("pipeline succeeds when no division by zero"):
    assertEquals(Chains.pipeline(100, 5, 4), Some(5))

  test("pipeline returns None on first zero divisor"):
    assertEquals(Chains.pipeline(100, 0, 4), None)

  test("pipeline returns None on second zero divisor"):
    assertEquals(Chains.pipeline(100, 5, 0), None)

  test("eitherPipeline returns Right for valid inputs"):
    assertEquals(Chains.eitherPipeline(100, 5), Right(200))

  test("eitherPipeline returns Left for division by zero"):
    assertEquals(Chains.eitherPipeline(100, 0), Left("division by zero"))
