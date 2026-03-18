package com.codegik.monads

// State[S, A] wraps a function  S => (S, A)  — given an initial state,
// produce a (possibly modified) state and a result value.
final case class State[S, A](run: S => (S, A)) {

  def map[B](f: A => B): State[S, B] =
    State { s =>
      val (s1, a) = run(s)
      (s1, f(a))
    }

  def flatMap[B](f: A => State[S, B]): State[S, B] =
    State { s =>
      val (s1, a) = run(s)
      f(a).run(s1)
    }

  /** Run and return only the final result. */
  def eval(initial: S): A = run(initial)._2

  /** Run and return only the final state. */
  def exec(initial: S): S = run(initial)._1
}

object State {
  /** Lift a pure value; state passes through unchanged. */
  def pure[S, A](a: A): State[S, A] = State(s => (s, a))

  /** Retrieve the current state as the result. */
  def get[S]: State[S, S] = State(s => (s, s))

  /** Replace the state entirely. */
  def set[S](newState: S): State[S, Unit] = State(_ => (newState, ()))

  /** Apply a function to the state. */
  def modify[S](f: S => S): State[S, Unit] = State(s => (f(s), ()))

  /** Read a projection of the state. */
  def gets[S, A](f: S => A): State[S, A] = State(s => (s, f(s)))

  /** Monad instance for a fixed state type S. */
  given stateMonad[S]: Monad[[X] =>> State[S, X]] with {
    def pure[A](a: A): State[S, A]                                        = State.pure(a)
    def flatMap[A, B](fa: State[S, A])(f: A => State[S, B]): State[S, B] = fa.flatMap(f)
  }
}

// Demo
object StateDemo {

  type Counter = State[Int, Unit]

  val increment: Counter = State.modify(_ + 1)
  val decrement: Counter = State.modify(_ - 1)
  val reset: Counter     = State.set(0)

  val counterProgram: State[Int, String] =
    for {
      _   <- increment
      _   <- increment
      _   <- increment
      n1  <- State.get
      _   <- decrement
      n2  <- State.get
      _   <- reset
      n3  <- State.get
    } yield s"after +3=$n1  after -1=$n2  after reset=$n3"

  type Stack[A] = List[A]

  def push[A](a: A): State[Stack[A], Unit] = State.modify(a :: _)

  def pop[A]: State[Stack[A], Option[A]] = State {
    case Nil     => (Nil, None)
    case h :: t  => (t, Some(h))
  }

  val stackProgram: State[Stack[Int], String] =
    for {
      _   <- push(10)
      _   <- push(20)
      _   <- push(30)
      top <- pop
      _   <- pop
      s   <- State.get
    } yield s"popped=$top  remaining=$s"

  def run(): Unit = {
    println("\n=== State Monad ===")

    val (finalState, msg) = counterProgram.run(0)
    println(s"  [State] counter: $msg, finalState=$finalState")

    val (finalStack, stackMsg) = stackProgram.run(List.empty)
    println(s"  [State] stack: $stackMsg, finalStack=$finalStack")
  }
}
