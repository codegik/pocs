package cats_poc

import cats.*
import cats.implicits.*

// ── Functor / Applicative / Monad ────────────────────────────────────────────

object Functors:
  // Functor: map a function over a wrapped value
  def doubleInside[F[_]: Functor](fa: F[Int]): F[Int] =
    fa.map(_ * 2)

  // Applicative: lift a pure value into a context
  def pureValue[F[_]: Applicative](a: Int): F[Int] =
    a.pure[F]

  // Apply: combine two independent effects and merge results
  def combineEffects[F[_]: Apply](fa: F[Int], fb: F[Int]): F[Int] =
    (fa, fb).mapN(_ + _)


// ── Semigroup / Monoid ───────────────────────────────────────────────────────

object Monoids:
  // Semigroup: combine two values
  def combine[A: Semigroup](a: A, b: A): A =
    a |+| b

  // Monoid: fold a list using the zero + combine
  def sumAll[A: Monoid](values: List[A]): A =
    values.combineAll


// ── Eq / Order / Show ────────────────────────────────────────────────────────

case class User(id: Int, name: String, age: Int)

object UserInstances:
  given Eq[User]    = Eq.by(_.id)
  given Order[User] = Order.by(_.age)
  given Show[User]  = Show.show(u => s"User(${u.id}, ${u.name}, age=${u.age})")


// ── Validated ────────────────────────────────────────────────────────────────

import cats.data.Validated
import cats.data.Validated.*

object Validation:
  type ValidationResult[A] = Validated[List[String], A]

  def validateName(name: String): ValidationResult[String] =
    if name.nonEmpty then name.valid
    else List("Name must not be empty").invalid

  def validateAge(age: Int): ValidationResult[Int] =
    if age >= 0 && age <= 150 then age.valid
    else List("Age must be between 0 and 150").invalid

  def validateUser(name: String, age: Int): ValidationResult[User] =
    (validateName(name), validateAge(age)).mapN((n, a) => User(0, n, a))


// ── Option / Either monad chaining ──────────────────────────────────────────

object Chains:
  def safeDivide(a: Int, b: Int): Option[Int] =
    if b == 0 then None else Some(a / b)

  def pipeline(a: Int, b: Int, c: Int): Option[Int] =
    for
      x <- safeDivide(a, b)
      y <- safeDivide(x, c)
    yield y

  def eitherPipeline(a: Int, b: Int): Either[String, Int] =
    for
      x <- if b == 0 then Left("division by zero") else Right(a / b)
      y <- if x < 0  then Left("negative result")  else Right(x * 10)
    yield y
