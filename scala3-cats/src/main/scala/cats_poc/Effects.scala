package cats_poc

import cats.effect.*
import cats.effect.implicits.*
import cats.implicits.*

// ── IO basics ────────────────────────────────────────────────────────────────

object IOExamples:
  val helloIO: IO[String] = IO.pure("hello")

  val sideEffect: IO[Unit] = IO.println("side effect ran")

  def delayed(n: Int): IO[Int] = IO.delay(n * 2)

  def pipeline(a: Int, b: Int): IO[Int] =
    for
      x <- IO.delay(a + b)
      y <- IO.delay(x * 2)
    yield y


// ── Error handling with IO ───────────────────────────────────────────────────

object IOErrors:
  def safeDivide(a: Int, b: Int): IO[Int] =
    if b == 0 then IO.raiseError(new ArithmeticException("division by zero"))
    else IO.pure(a / b)

  def withFallback(a: Int, b: Int): IO[Int] =
    safeDivide(a, b).handleErrorWith(_ => IO.pure(-1))

  def attempt(a: Int, b: Int): IO[Either[Throwable, Int]] =
    safeDivide(a, b).attempt


// ── Parallel execution ───────────────────────────────────────────────────────

object IOParallel:
  def tasks(values: List[Int]): IO[List[Int]] =
    values.parTraverse(n => IO.delay(n * 3))

  def bothResults: IO[(String, Int)] =
    (IO.pure("hello"), IO.pure(42)).parTupled


// ── Resource management ──────────────────────────────────────────────────────

object Resources:
  case class Connection(id: Int):
    def query(sql: String): IO[String] = IO.pure(s"result of [$sql] via conn#$id")

  def makeConnection(id: Int): Resource[IO, Connection] =
    Resource.make(
      IO.delay(Connection(id))
    )(conn =>
      IO.delay(()) // close connection
    )

  def runQuery(id: Int, sql: String): IO[String] =
    makeConnection(id).use(_.query(sql))
