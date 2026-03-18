package com.codegik.monads

// ---------------------------------------------------------------------------
// Entry point — runs all monad demos in sequence
// ---------------------------------------------------------------------------
// Monads implemented from scratch (no Cats / ZIO / Scalaz):
//
//   IO      — deferred side effects; referential transparency at the boundary
//   State   — thread mutable state through pure computations
//   Reader  — dependency injection via a shared environment
//   Writer  — accumulate a log / audit trail alongside a result
//   Free    — build programs as data, interpret them later (swap interpreters)
// ---------------------------------------------------------------------------

@main def run(): Unit =
  IODemo.run()
  StateDemo.run()
  ReaderDemo.run()
  WriterDemo.run()
  FreeDemo.run()
  println()
