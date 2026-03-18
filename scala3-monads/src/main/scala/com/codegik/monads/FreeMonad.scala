package com.codegik.monads

/** Natural transformation: converts F[A] to G[A] for every type A. */
trait ~>[F[_], G[_]] {
  def apply[A](fa: F[A]): G[A]
}

/** The Free monad. */
sealed abstract class Free[F[_], A] {

  final def map[B](f: A => B): Free[F, B] =
    flatMap(a => Free.pure(f(a)))

  final def flatMap[B](f: A => Free[F, B]): Free[F, B] =
    Free.FlatMapped(this, f)

  /** Fold/interpret this program using a natural transformation into monad G. */
  final def foldMap[G[_]](nt: F ~> G)(using M: Monad[G]): G[A] =
    this match {
      case Free.Pure(a)           => M.pure(a)
      case Free.Suspend(fa)       => nt(fa)
      case Free.FlatMapped(fa, k) => M.flatMap(fa.foldMap(nt))(e => k(e).foldMap(nt))
    }
}

object Free {
  private[monads] case class Pure[F[_], A](a: A)                             extends Free[F, A]
  private[monads] case class Suspend[F[_], A](fa: F[A])                      extends Free[F, A]
  private[monads] case class FlatMapped[F[_], E, A](
    free: Free[F, E],
    f: E => Free[F, A]
  ) extends Free[F, A]

  def pure[F[_], A](a: A): Free[F, A]     = Pure(a)
  def lift[F[_], A](fa: F[A]): Free[F, A] = Suspend(fa)
}

// ---------------------------------------------------------------------------
// Algebra: Key-Value Store DSL
// ---------------------------------------------------------------------------
sealed trait KVOp[A]
object KVOp {
  case class Put(key: String, value: String) extends KVOp[Unit]
  case class Get(key: String)                extends KVOp[Option[String]]
  case class Delete(key: String)             extends KVOp[Unit]
}

// Smart constructors — lift each op into Free
def kvPut(key: String, value: String): Free[KVOp, Unit]        = Free.lift(KVOp.Put(key, value))
def kvGet(key: String): Free[KVOp, Option[String]]             = Free.lift(KVOp.Get(key))
def kvDelete(key: String): Free[KVOp, Unit]                    = Free.lift(KVOp.Delete(key))

// ---------------------------------------------------------------------------
// A program written against the KV algebra
// The program itself is pure data — no effects yet.
// ---------------------------------------------------------------------------
val kvProgram: Free[KVOp, String] =
  for {
    _     <- kvPut("user:1", "Alice")
    _     <- kvPut("user:2", "Bob")
    alice <- kvGet("user:1")
    _     <- kvDelete("user:2")
    bob   <- kvGet("user:2")           // should be None after delete
  } yield s"user:1=${alice.getOrElse("?")}  user:2=${bob.getOrElse("(deleted)")}"

// ---------------------------------------------------------------------------
// Interpreter 1: IO — wraps a mutable Map, printing each step
// ---------------------------------------------------------------------------
def ioInterpreter(store: scala.collection.mutable.Map[String, String])
    : KVOp ~> IO = new (KVOp ~> IO) {
  def apply[A](op: KVOp[A]): IO[A] = op match {
    case KVOp.Put(k, v) =>
      IO.delay { println(s"  [Free/IO] PUT $k = $v"); store(k) = v }
    case KVOp.Get(k) =>
      IO.delay { val r = store.get(k); println(s"  [Free/IO] GET $k => $r"); r }
    case KVOp.Delete(k) =>
      IO.delay { println(s"  [Free/IO] DEL $k"); store.remove(k); () }
  }
}

// ---------------------------------------------------------------------------
// Interpreter 2: State — pure in-memory, no side effects at all
// ---------------------------------------------------------------------------
type KVMap     = Map[String, String]
type KVState[A] = State[KVMap, A]

val stateInterpreter: KVOp ~> KVState = new (KVOp ~> KVState) {
  def apply[A](op: KVOp[A]): KVState[A] = op match {
    case KVOp.Put(k, v) => State.modify[KVMap](_.updated(k, v))
    case KVOp.Get(k)    => State.gets[KVMap, Option[String]](_.get(k))
    case KVOp.Delete(k) => State.modify[KVMap](_ - k)
  }
}

// Monad instance for KVState (type lambda to fix the state type)
given Monad[KVState] with {
  def pure[A](a: A): KVState[A]                          = State.pure(a)
  def flatMap[A, B](fa: KVState[A])(f: A => KVState[B]): KVState[B] = fa.flatMap(f)
}

// Demo
object FreeDemo {
  def run(): Unit = {
    println("\n=== Free Monad ===")
    println("  [Free] same program, two interpreters:\n")

    // --- Interpreter 1: IO (effectful) ---
    println("  [Free] -- IO Interpreter --")
    val store   = scala.collection.mutable.Map.empty[String, String]
    val ioResult = kvProgram.foldMap(ioInterpreter(store)).unsafeRun()
    println(s"  [Free] IO result: $ioResult")
    println(s"  [Free] final store: ${store.toMap}\n")

    // --- Interpreter 2: State (pure) ---
    println("  [Free] -- State Interpreter --")
    val (finalMap, stateResult) = kvProgram.foldMap(stateInterpreter).run(Map.empty)
    println(s"  [Free] State result : $stateResult")
    println(s"  [Free] final map    : $finalMap")
  }
}
