package com.codegik.monads

// ---------------------------------------------------------------------------
// IO Monad
// ---------------------------------------------------------------------------
final class IO[A](val unsafeRun: () => A):

  /** Transform the result without running any new effects. */
  def map[B](f: A => B): IO[B] =
    IO.delay(f(unsafeRun()))

  /** Sequence two effectful computations; the second may depend on the first. */
  def flatMap[B](f: A => IO[B]): IO[B] =
    IO.delay(f(unsafeRun()).unsafeRun())

  /** Run this, then run `next`; keep only `next`'s result. */
  def *>[B](next: IO[B]): IO[B] = flatMap(_ => next)

  /** Run this, then run `next`; keep only this result. */
  def <*[B](next: IO[B]): IO[A] = flatMap(a => next.map(_ => a))

  /** Discard the result, producing IO[Unit]. */
  def void: IO[Unit] = map(_ => ())

object IO:
  def apply[A](thunk: => A): IO[A]  = delay(thunk)
  def delay[A](thunk: => A): IO[A]  = new IO(() => thunk)
  def pure[A](a: A): IO[A]          = new IO(() => a)
  val unit: IO[Unit]                 = pure(())

  def println(msg: String): IO[Unit] = delay(Predef.println(msg))
  def print(msg: String): IO[Unit]   = delay(Predef.print(msg))
  def readLine: IO[String]           = delay(scala.io.StdIn.readLine())

  /** Run a list of IOs in order and collect results. */
  def sequence[A](ios: List[IO[A]]): IO[List[A]] =
    ios.foldRight(IO.pure(List.empty[A])) { (io, acc) =>
      for
        a  <- io
        as <- acc
      yield a :: as
    }

  // Monad instance — required when IO is used as interpreter target for Free
  given Monad[IO] with
    def pure[A](a: A): IO[A]                          = IO.pure(a)
    def flatMap[A, B](fa: IO[A])(f: A => IO[B]): IO[B] = fa.flatMap(f)

// Demo
object IODemo:
  def run(): Unit =
    println("\n=== IO Monad ===")

    // 1. An IO value is a *description*, not an execution
    val effect1: IO[Unit] = IO.println("  [IO] effect1 — deferred until run")
    val effect2: IO[Int]  = IO.delay { println("  [IO] effect2 — computing 6 * 7"); 42 }

    println("  [IO] IO values created, nothing executed yet.")

    // 2. Compose with for-comprehension (desugars to map/flatMap)
    val program: IO[String] =
      for
        _   <- IO.println("  [IO] step 1: starting program")
        n   <- effect2
        msg  = s"  [IO] step 2: result is $n"
        _   <- IO.println(msg)
        _   <- IO.println("  [IO] step 3: done")
      yield s"finished with $n"

    // 3. Nothing has run yet — only when we call unsafeRun do effects fire
    val result = program.unsafeRun()
    println(s"  [IO] program returned: $result")

    // 4. Running the same IO again repeats the effect (referential transparency)
    println("  [IO] running effect1 twice:")
    effect1.unsafeRun()
    effect1.unsafeRun()

    // 5. Sequence a list of IOs
    val tasks: List[IO[String]] =
      List("alpha", "beta", "gamma").map(s => IO.pure(s.toUpperCase))
    val all = IO.sequence(tasks).unsafeRun()
    println(s"  [IO] sequenced: $all")
