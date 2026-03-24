package macros

import scala.quoted.*

// ---------------------------------------------------------------------------
// Compile-time validation macros
//
// Every check here is performed by the Scala compiler, not at runtime.
// Passing an invalid literal is a compilation error, not an exception.
// ---------------------------------------------------------------------------
object Validation:

  // ── nonEmpty ─────────────────────────────────────────────────────────────

  /** Fails compilation if the string literal is empty. */
  inline def nonEmpty(inline s: String): String = ${ nonEmptyImpl('s) }

  def nonEmptyImpl(s: Expr[String])(using Quotes): Expr[String] =
    import quotes.reflect.*
    s.value match
      case Some("") => report.errorAndAbort("String must not be empty")
      case Some(_)  => s
      case None     => report.errorAndAbort("nonEmpty requires a string literal known at compile time")

  // ── matchesPattern ───────────────────────────────────────────────────────

  /** Fails compilation if the string literal does not match the regex pattern. */
  inline def matchesPattern(inline s: String, inline pattern: String): String =
    ${ matchesPatternImpl('s, 'pattern) }

  def matchesPatternImpl(s: Expr[String], pattern: Expr[String])(using Quotes): Expr[String] =
    import quotes.reflect.*
    (s.value, pattern.value) match
      case (Some(str), Some(pat)) =>
        try
          if java.util.regex.Pattern.compile(pat).matcher(str).matches() then s
          else report.errorAndAbort(s""""$str" does not match pattern "$pat"""")
        catch
          case e: java.util.regex.PatternSyntaxException =>
            report.errorAndAbort(s"Invalid regex: ${e.getMessage}")
      case _ =>
        report.errorAndAbort("matchesPattern requires string literals known at compile time")

  // ── email ────────────────────────────────────────────────────────────────

  /** Fails compilation if the string literal is not a valid e-mail address. */
  inline def email(inline s: String): String = ${ emailImpl('s) }

  private val EmailRegex = """^[a-zA-Z0-9._%+\-]+@[a-zA-Z0-9.\-]+\.[a-zA-Z]{2,}$"""

  def emailImpl(s: Expr[String])(using Quotes): Expr[String] =
    import quotes.reflect.*
    s.value match
      case Some(str) =>
        if str.matches(EmailRegex) then s
        else report.errorAndAbort(s""""$str" is not a valid e-mail address""")
      case None =>
        report.errorAndAbort("email requires a string literal known at compile time")

  // ── inRange ──────────────────────────────────────────────────────────────

  /** Fails compilation if the integer literal is outside [min, max]. */
  inline def inRange(inline n: Int, inline min: Int, inline max: Int): Int =
    ${ inRangeImpl('n, 'min, 'max) }

  def inRangeImpl(n: Expr[Int], min: Expr[Int], max: Expr[Int])(using Quotes): Expr[Int] =
    import quotes.reflect.*
    (n.value, min.value, max.value) match
      case (Some(v), Some(lo), Some(hi)) =>
        if v < lo || v > hi then
          report.errorAndAbort(s"Value $v is out of range [$lo, $hi]")
        else n
      case _ =>
        report.errorAndAbort("inRange requires integer literals known at compile time")

  // ── assert ───────────────────────────────────────────────────────────────

  // This is useful for enforcing invariants between compile-time constants
  // (e.g., buffer sizes, port numbers, table dimensions).
  /** Fails compilation with a custom message if the boolean condition is false. */
  inline def assert(inline cond: Boolean, inline msg: String): Unit =
    ${ assertImpl('cond, 'msg) }

  def assertImpl(cond: Expr[Boolean], msg: Expr[String])(using Quotes): Expr[Unit] =
    import quotes.reflect.*
    (cond.value, msg.value) match
      case (Some(false), Some(m)) =>
        report.errorAndAbort(s"Compile-time assertion failed: $m")
      case (Some(true), _) =>
        '{ () }
      case _ =>
        report.errorAndAbort("assert requires compile-time constant values")

  // ── validUrl ─────────────────────────────────────────────────────────────

  /** Fails compilation if the string literal is not a valid HTTP/HTTPS URL. */
  inline def validUrl(inline s: String): String = ${ validUrlImpl('s) }

  def validUrlImpl(s: Expr[String])(using Quotes): Expr[String] =
    import quotes.reflect.*
    s.value match
      case Some(str) =>
        try
          val uri = java.net.URI.create(str)
          val scheme = uri.getScheme
          if scheme == null || (!scheme.equals("http") && !scheme.equals("https")) then
            report.errorAndAbort(s""""$str" is not a valid http/https URL""")
          s
        catch
          case _: IllegalArgumentException =>
            report.errorAndAbort(s""""$str" is not a valid URL""")
      case None =>
        report.errorAndAbort("validUrl requires a string literal known at compile time")
