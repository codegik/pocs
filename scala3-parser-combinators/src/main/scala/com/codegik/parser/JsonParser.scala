package com.codegik.parser

import ParseResult.*

enum Json:
  case JNull
  case JBool(value: Boolean)
  case JNumber(value: Double)
  case JString(value: String)
  case JArray(values: List[Json])
  case JObject(fields: Map[String, Json])

  override def toString: String = this match
    case JNull          => "null"
    case JBool(v)       => v.toString
    case JNumber(v)     => if v == v.toLong then v.toLong.toString else v.toString
    case JString(v)     => s"\"$v\""
    case JArray(vs)     => vs.mkString("[", ", ", "]")
    case JObject(fs)    => fs.map((k, v) => s"\"$k\": $v").mkString("{", ", ", "}")

object JsonParser:
  import Parser.*

  val jNull: Parser[Json] =
    string("null").map(_ => Json.JNull)

  val jBool: Parser[Json] =
    choice(
      string("true").map(_ => Json.JBool(true)),
      string("false").map(_ => Json.JBool(false))
    )

  val jNumber: Parser[Json] =
    token(
      (char('-').opt ~ digit.many1 ~ (char('.') ~> digit.many1).opt).map:
        case ((sign, intDigits), fracDigits) =>
          val s = sign.map(_.toString).getOrElse("") +
                  intDigits.mkString +
                  fracDigits.map(ds => "." + ds.mkString).getOrElse("")
          Json.JNumber(s.toDouble)
    )

  val stringLiteral: Parser[String] =
    val escapedChar = char('\\') ~> anyChar
    val normalChar  = satisfy(c => c != '"' && c != '\\', "string char")
    token(char('"') ~> (escapedChar or normalChar).many <~ char('"')).map(_.mkString)

  val jString: Parser[Json] =
    stringLiteral.map(Json.JString.apply)

  lazy val jValue: Parser[Json] =
    token(choice(jNull, jBool, jNumber, jString, jArray, jObject))

  lazy val jArray: Parser[Json] =
    jValue.sepBy(token(char(','))).between(token(char('[')), token(char(']'))).map(Json.JArray.apply)

  lazy val jObject: Parser[Json] =
    val field: Parser[(String, Json)] =
      for
        key <- stringLiteral
        _   <- token(char(':'))
        v   <- jValue
      yield (key, v)
    field.sepBy(token(char(','))).between(token(char('{')), token(char('}'))).map(fs => Json.JObject(fs.toMap))

  def parse(input: String): ParseResult[Json] = jValue.parse(input)
