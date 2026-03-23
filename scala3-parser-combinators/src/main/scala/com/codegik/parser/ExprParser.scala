package com.codegik.parser

import ParseResult.*

// AST for arithmetic expressions
enum Expr {
  case Num(value: Double)
  case Add(left: Expr, right: Expr)
  case Sub(left: Expr, right: Expr)
  case Mul(left: Expr, right: Expr)
  case Div(left: Expr, right: Expr)

  def eval: Double = this match {
    case Num(v)    => v
    case Add(l, r) => l.eval + r.eval
    case Sub(l, r) => l.eval - r.eval
    case Mul(l, r) => l.eval * r.eval
    case Div(l, r) => l.eval / r.eval
  }
}

// Grammar (respects precedence):
//   expr   = term   (('+' | '-') term)*
//   term   = factor (('*' | '/') factor)*
//   factor = number | '(' expr ')'
//   number = digit+ ('.' digit+)?
object ExprParser {
  import Parser.*

  val number: Parser[Expr] =
    token(
      (digit.many1 ~ (char('.') ~> digit.many1).opt).map {
        case (intDigits, fracDigits) =>
          val intPart  = intDigits.mkString
          val fracPart = fracDigits.map(ds => "." + ds.mkString).getOrElse("")
          Expr.Num((intPart + fracPart).toDouble)
      }
    )

  // Forward reference for recursion
  lazy val expr: Parser[Expr] = addSub

  lazy val factor: Parser[Expr] =
    number.or(expr.between(token(char('(')), token(char(')'))))

  lazy val term: Parser[Expr] =
    (factor ~ (token(choice(char('*'), char('/'))) ~ factor).many).map {
      case (first, ops) =>
        ops.foldLeft(first) {
          case (acc, ('*', rhs)) => Expr.Mul(acc, rhs)
          case (acc, ('/', rhs)) => Expr.Div(acc, rhs)
          case (acc, _)          => acc
        }
    }

  lazy val addSub: Parser[Expr] =
    (term ~ (token(choice(char('+'), char('-'))) ~ term).many).map {
      case (first, ops) =>
        ops.foldLeft(first) {
          case (acc, ('+', rhs)) => Expr.Add(acc, rhs)
          case (acc, ('-', rhs)) => Expr.Sub(acc, rhs)
          case (acc, _)          => acc
        }
    }

  def parse(input: String): ParseResult[Expr] = expr.parse(input)

  def eval(input: String): Either[String, Double] =
    parse(input) match {
      case ParseResult.Success(expr, _) => Right(expr.eval)
      case ParseResult.Failure(msg, _)  => Left(msg)
    }
}
