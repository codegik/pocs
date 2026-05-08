package cats_poc

import cats.*
import cats.data.*
import cats.implicits.*

// ── NonEmptyList ─────────────────────────────────────────────────────────────

object NonEmptyLists:
  def head[A](nel: NonEmptyList[A]): A = nel.head

  def append[A](nel: NonEmptyList[A], a: A): NonEmptyList[A] =
    nel.append(a)

  def fromList[A](list: List[A]): Option[NonEmptyList[A]] =
    NonEmptyList.fromList(list)


// ── EitherT (monad transformer) ──────────────────────────────────────────────

object EitherTransformer:
  type Result[A] = EitherT[Option, String, A]

  // Wraps an Option[Either[String, A]] in EitherT for ergonomic chaining
  def findUser(id: Int): Result[User] =
    val db = Map(1 -> User(1, "Alice", 30), 2 -> User(2, "Bob", 15))
    EitherT.fromOption(db.get(id), s"User $id not found")

  def validateAdult(user: User): Result[User] =
    EitherT.cond(user.age >= 18, user, s"${user.name} is underage")

  def getAdultUser(id: Int): Result[User] =
    for
      user  <- findUser(id)
      adult <- validateAdult(user)
    yield adult


// ── OptionT (monad transformer) ──────────────────────────────────────────────

object OptionTransformer:
  type Fallible[A] = OptionT[[X] =>> Either[String, X], A]

  def parseId(s: String): Either[String, Int] =
    s.toIntOption.toRight(s"'$s' is not a valid integer")

  def lookup(id: Int): Option[String] =
    Map(1 -> "alpha", 2 -> "beta").get(id)

  def resolve(s: String): Either[String, Option[String]] =
    parseId(s).map(lookup)


// ── Writer (logging / accumulation) ──────────────────────────────────────────

object Writers:
  type Logged[A] = Writer[List[String], A]

  def factorial(n: Int): Logged[Int] =
    if n <= 1 then
      Writer(List(s"base case: 1"), 1)
    else
      factorial(n - 1).flatMap { prev =>
        val result = prev * n
        Writer(List(s"$n! = $result"), result)
      }


// ── State ────────────────────────────────────────────────────────────────────

object States:
  type Stack[A] = State[List[Int], A]

  val push: Int => Stack[Unit] =
    n => State.modify(n :: _)

  val pop: Stack[Option[Int]] =
    State.get.flatMap {
      case Nil    => State.pure(None)
      case h :: t => State.set(t).as(Some(h))
    }

  def program(toPush: List[Int]): Stack[List[Option[Int]]] =
    for
      _    <- toPush.traverse(push)
      pops <- List.fill(toPush.size)(pop).sequence
    yield pops
