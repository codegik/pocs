package macros

import scala.quoted.*

// ---------------------------------------------------------------------------
// Simple macro examples — one concept per macro
// ---------------------------------------------------------------------------
object Simple:

  // ── Level 1 ───────────────────────────────────────────────────────────────

  // The simplest possible macro: capture the source text of any expression.
  // expr.show returns the internal quoted representation of the expression tree.
  /** Returns the source code of any expression as a String. */
  inline def stringify(inline expr: Any): String = ${ stringifyImpl('expr) }

  def stringifyImpl(expr: Expr[Any])(using Quotes): Expr[String] =
    Expr(expr.show)

  // One step further: evaluate the expression, but also print its source name
  // alongside its value — similar to Python's f"{x=}" syntax.
  /** Prints "source = value" then returns the value unchanged. */
  inline def debug[A](inline expr: A): A = ${ debugImpl('expr) }

  def debugImpl[A: Type](expr: Expr[A])(using Quotes): Expr[A] =
    val src = Expr(expr.show)   // captured at compile time
    '{
      val result = $expr
      println(s"${$src} = $result")
      result
    }

  // Splicing the same Expr twice generates two independent evaluations —
  // the macro does not cache the result. This is intentional for `twice`.
  /** Runs the block twice and returns the last result. */
  inline def twice[A](inline block: A): A = ${ twiceImpl('block) }

  def twiceImpl[A: Type](block: Expr[A])(using Quotes): Expr[A] =
    '{
      $block
      $block
    }

  // ── Level 2 ───────────────────────────────────────────────────────────────

  // The macro checks primality using only the Scala standard library at
  // compile time. Passing a non-prime literal is a *compilation error*.
  /** Fails compilation if the integer literal is not a prime number. */
  inline def isPrime(inline n: Int): Int = ${ isPrimeImpl('n) }

  def isPrimeImpl(n: Expr[Int])(using Quotes): Expr[Int] =
    import quotes.reflect.*
    n.value match
      case None =>
        report.errorAndAbort("isPrime requires an integer literal known at compile time")
      case Some(v) if v < 2 =>
        report.errorAndAbort(s"$v is not a prime number")
      case Some(v) =>
        val prime = (2 to math.sqrt(v.toDouble).toInt).forall(v % _ != 0)
        if prime then n
        else report.errorAndAbort(s"$v is not a prime number")

  // Validates the string against a CSS hex colour pattern (#RGB / #RRGGBB).
  // Both the validation logic and the regex run entirely inside the compiler.
  /** Fails compilation if the string literal is not a valid CSS hex colour. */
  inline def hex(inline s: String): String = ${ hexImpl('s) }

  def hexImpl(s: Expr[String])(using Quotes): Expr[String] =
    import quotes.reflect.*
    s.value match
      case None =>
        report.errorAndAbort("hex requires a string literal known at compile time")
      case Some(str) =>
        if str.matches("#[0-9a-fA-F]{3}|#[0-9a-fA-F]{6}") then s
        else report.errorAndAbort(s""""$str" is not a valid hex colour (#RGB or #RRGGBB)""")

  // TypeRepr.of[T].show resolves the full type (including type arguments) and
  // returns it as a String constant embedded in the bytecode — no runtime
  // reflection needed to ask "what type is this?".
  /** Returns the fully-resolved type name of T as a compile-time String constant. */
  inline def printType[T]: String = ${ printTypeImpl[T] }

  def printTypeImpl[T: Type](using Quotes): Expr[String] =
    import quotes.reflect.*
    Expr(TypeRepr.of[T].show)
