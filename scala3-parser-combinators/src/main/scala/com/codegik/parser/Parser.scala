package com.codegik.parser

import ParseResult.*

// A parser is a function from input string to a parse result
case class Parser[+A](run: String => ParseResult[A]) {

  def parse(input: String): ParseResult[A] = run(input)

  // Functor: transform the parsed value
  def map[B](f: A => B): Parser[B] =
    Parser(input => run(input).map(f))

  // Monad: sequence parsers, feeding result to next
  def flatMap[B](f: A => Parser[B]): Parser[B] =
    Parser { input =>
      run(input) match {
        case Success(v, rest) => f(v).run(rest)
        case Failure(m, r)    => Failure(m, r)
      }
    }

  // Alternative: try this parser, fallback to other on failure
  def or[B >: A](other: => Parser[B]): Parser[B] =
    Parser { input =>
      run(input) match {
        case s @ Success(_, _) => s
        case Failure(_, _)     => other.run(input)
      }
    }

  // Sequence: run both, keep both results as a tuple
  def ~[B](other: => Parser[B]): Parser[(A, B)] =
    for {
      a <- this
      b <- other
    } yield (a, b)

  // Sequence: run both, keep only left result
  def <~[B](other: => Parser[B]): Parser[A] =
    (this ~ other).map(_._1)

  // Sequence: run both, keep only right result
  def ~>[B](other: => Parser[B]): Parser[B] =
    (this ~ other).map(_._2)

  // Repeat zero or more times
  def many: Parser[List[A]] =
    Parser { input =>
      def loop(in: String, acc: List[A]): ParseResult[List[A]] =
        run(in) match {
          case Success(v, rest) => loop(rest, acc :+ v)
          case Failure(_, _)    => Success(acc, in)
        }
      loop(input, Nil)
    }

  // Repeat one or more times
  def many1: Parser[List[A]] =
    for {
      first <- this
      rest  <- this.many
    } yield first :: rest

  // Optional: zero or one occurrence
  def opt: Parser[Option[A]] =
    Parser { input =>
      run(input) match {
        case Success(v, rest) => Success(Some(v), rest)
        case Failure(_, _)    => Success(None, input)
      }
    }

  // Surround with two other parsers (e.g. brackets)
  def between[L, R](left: Parser[L], right: Parser[R]): Parser[A] =
    left ~> this <~ right

  // Separated by a delimiter, zero or more
  def sepBy[S](sep: Parser[S]): Parser[List[A]] =
    (this ~ (sep ~> this).many).map((h, t) => h :: t).or(Parser.pure(Nil))
}

object Parser {

  // Always succeed with a value without consuming input
  def pure[A](value: A): Parser[A] =
    Parser(input => Success(value, input))

  // Always fail
  def fail[A](msg: String): Parser[A] =
    Parser(input => Failure(msg, input))

  // Parse a single character matching a predicate
  def satisfy(pred: Char => Boolean, label: String = "satisfy"): Parser[Char] =
    Parser {
      case ""                => Failure(s"Expected $label but got end of input", "")
      case s if pred(s.head) => Success(s.head, s.tail)
      case s                 => Failure(s"Expected $label but got '${s.head}'", s)
    }

  // Parse an exact character
  def char(c: Char): Parser[Char] =
    satisfy(_ == c, s"'$c'")

  // Parse an exact string
  def string(s: String): Parser[String] =
    Parser { input =>
      if (input.startsWith(s)) Success(s, input.drop(s.length))
      else Failure(s"Expected \"$s\"", input)
    }

  // Parse any single character
  val anyChar: Parser[Char] =
    satisfy(_ => true, "any char")

  // Parse a digit character
  val digit: Parser[Char] =
    satisfy(_.isDigit, "digit")

  // Parse a letter character
  val letter: Parser[Char] =
    satisfy(_.isLetter, "letter")

  // Parse a letter or digit
  val alphaNum: Parser[Char] =
    satisfy(_.isLetterOrDigit, "alphanumeric")

  // Parse whitespace (space, tab, newline)
  val whitespaceChar: Parser[Char] =
    satisfy(c => c == ' ' || c == '\t' || c == '\n' || c == '\r', "whitespace")

  val whitespace: Parser[String] =
    whitespaceChar.many.map(_.mkString)

  val whitespace1: Parser[String] =
    whitespaceChar.many1.map(_.mkString)

  // Skip surrounding whitespace
  def token[A](p: Parser[A]): Parser[A] =
    whitespace ~> p <~ whitespace

  // Try parsers in order, return first success
  def choice[A](parsers: Parser[A]*): Parser[A] =
    parsers.reduceLeft(_ or _)
}
