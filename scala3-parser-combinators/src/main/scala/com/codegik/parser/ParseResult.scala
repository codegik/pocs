package com.codegik.parser

enum ParseResult[+A] {
  case Success(value: A, rest: String)
  case Failure(message: String, rest: String)

  def map[B](f: A => B): ParseResult[B] = this match {
    case Success(v, r) => Success(f(v), r)
    case Failure(m, r) => Failure(m, r)
  }

  def isSuccess: Boolean = this match {
    case Success(_, _) => true
    case Failure(_, _) => false
  }

  def get: A = this match {
    case Success(v, _) => v
    case Failure(m, _) => throw RuntimeException(s"ParseResult.get on Failure: $m")
  }
}
