package com.codegik.monads

// Entry point — runs all monad demos in sequence
@main def run(): Unit = {
  IODemo.run()
  StateDemo.run()
  ReaderDemo.run()
  WriterDemo.run()
  FreeDemo.run()
  println()
}
