package cats_poc

import cats.*
import cats.data.*
import cats.effect.*
import cats.implicits.*

object Main extends IOApp.Simple:

  def run: IO[Unit] =
    for
      _ <- IO.println("=== Cats Typeclasses ===")
      _ <- IO.println(s"Functor(List):   ${Functors.doubleInside(List(1, 2, 3))}")
      _ <- IO.println(s"Functor(Option): ${Functors.doubleInside(Option(5))}")
      _ <- IO.println(s"combine strings: ${Monoids.combine("hello ", "world")}")
      _ <- IO.println(s"sumAll ints:     ${Monoids.sumAll(List(1, 2, 3, 4, 5))}")

      _ <- IO.println("\n=== Validated ===")
      _ <- IO.println(s"valid user:   ${Validation.validateUser("Alice", 30)}")
      _ <- IO.println(s"invalid user: ${Validation.validateUser("", -1)}")

      _ <- IO.println("\n=== EitherT transformer ===")
      _ <- IO.println(s"adult user:    ${EitherTransformer.getAdultUser(1)}")
      _ <- IO.println(s"underage user: ${EitherTransformer.getAdultUser(2)}")
      _ <- IO.println(s"missing user:  ${EitherTransformer.getAdultUser(99)}")

      _ <- IO.println("\n=== Writer ===")
      writerResult = Writers.factorial(5).run
      _ <- IO.println(s"5! = ${writerResult._2}")
      _ <- writerResult._1.traverse(l => IO.println(s"  $l"))

      _ <- IO.println("\n=== State ===")
      stateResult = States.program(List(1, 2, 3)).run(Nil).value
      _ <- IO.println(s"pops: ${stateResult._2}, remaining stack: ${stateResult._1}")

      _ <- IO.println("\n=== IO Effects ===")
      r1 <- IOExamples.pipeline(3, 4)
      _  <- IO.println(s"pipeline(3,4): $r1")
      r2 <- IOErrors.withFallback(10, 0)
      _  <- IO.println(s"withFallback(10,0): $r2")
      r3 <- IOParallel.tasks(List(1, 2, 3, 4))
      _  <- IO.println(s"parTraverse *3: $r3")
      r4 <- Resources.runQuery(1, "SELECT * FROM users")
      _  <- IO.println(s"resource query: $r4")
    yield ()
