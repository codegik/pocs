package com.codegik.monads

// ---------------------------------------------------------------------------
// Writer Monad
// ---------------------------------------------------------------------------
// Writer[W, A] pairs a result A with an accumulated log W.
// W must be a Monoid so logs from successive steps can be combined.
//
// Canonical use-cases: structured logging, audit trails, collecting
// intermediate results alongside a final answer.
//
//   val compute: Writer[List[String], Int] = for
//     _  <- Writer.tell(List("start"))
//     x  <- Writer.pure(21)
//     _  <- Writer.tell(List("doubling"))
//     r  <- Writer.pure(x * 2)
//   yield r
//
//   compute.run   // => (List("start","doubling"), 42)
// ---------------------------------------------------------------------------

final case class Writer[W, A](run: (W, A)):

  def value: A   = run._2
  def written: W = run._1

  def map[B](f: A => B): Writer[W, B] =
    Writer((run._1, f(run._2)))

  def flatMap[B](f: A => Writer[W, B])(using m: Monoid[W]): Writer[W, B] =
    val (w1, a) = run
    val (w2, b) = f(a).run
    Writer((m.combine(w1, w2), b))

object Writer:
  /** Lift a pure value with an empty log. */
  def pure[W, A](a: A)(using m: Monoid[W]): Writer[W, A] =
    Writer((m.empty, a))

  /** Emit a log entry and return Unit. */
  def tell[W](w: W): Writer[W, Unit] =
    Writer((w, ()))

  /** Combine a log entry with a result value. */
  def writer[W, A](w: W, a: A): Writer[W, A] =
    Writer((w, a))

// ---------------------------------------------------------------------------
// Demo
// ---------------------------------------------------------------------------
object WriterDemo:

  // ---- Example 1: string log (Writer[String, *]) -------------------------

  def divSafe(a: Int, b: Int): Writer[String, Option[Int]] =
    if b == 0 then Writer.writer("WARN: division by zero; ", None)
    else Writer.writer(s"OK: $a / $b = ${a / b}; ", Some(a / b))

  val computationLog: Writer[String, Int] =
    for
      _  <- Writer.writer("start; ", ())
      r1 <- divSafe(100, 5)
      _  <- Writer.tell("checkpoint; ")
      r2 <- divSafe(50, 0)
      _  <- Writer.tell("end; ")
    yield r1.getOrElse(0) + r2.getOrElse(0)

  // ---- Example 2: structured audit log (Writer[List[String], *]) ---------

  case class Order(id: String, items: List[String], total: Double)

  def validateOrder(o: Order): Writer[List[String], Boolean] =
    for
      _         <- Writer.tell(List(s"[audit] validating order ${o.id}"))
      hasItems   = o.items.nonEmpty
      _         <- Writer.tell(
                     if hasItems then List(s"[audit] ${o.items.size} items OK")
                     else List("[audit] FAIL: no items")
                   )
      validTotal = o.total > 0
      _         <- Writer.tell(
                     if validTotal then List(s"[audit] total ${o.total} OK")
                     else List(s"[audit] FAIL: invalid total ${o.total}")
                   )
      _         <- Writer.tell(List(s"[audit] result: ${hasItems && validTotal}"))
    yield hasItems && validTotal

  def run(): Unit =
    println("\n=== Writer Monad ===")

    // Example 1
    val (log1, result1) = computationLog.run
    println(s"  [Writer] string log  : $log1")
    println(s"  [Writer] result      : $result1")

    // Example 2
    val order   = Order("ORD-001", List("pizza", "cola"), 29.90)
    val (auditLog, valid) = validateOrder(order).run
    auditLog.foreach(l => println(s"  [Writer] $l"))
    println(s"  [Writer] order valid : $valid")

    // Invalid order
    val badOrder = Order("ORD-002", List.empty, -5.0)
    val (badLog, badValid) = validateOrder(badOrder).run
    badLog.foreach(l => println(s"  [Writer] $l"))
    println(s"  [Writer] order valid : $badValid")
