import com.codegik.parser.ExprParser
import com.codegik.parser.JsonParser

@main def run(): Unit =
  println("=== Arithmetic Expression Parser ===")
  val exprs = List("1 + 2", "3 * 4 + 5", "(1 + 2) * (3 - 1)", "10 / 2 + 3 * 4", "2.5 * 4")
  exprs.foreach: expr =>
    ExprParser.eval(expr) match
      case Right(result) => println(s"  $expr = $result")
      case Left(err)     => println(s"  ERROR: $err")

  println()
  println("=== JSON Parser ===")
  val jsons = List(
    """null""",
    """true""",
    """42""",
    """"hello world"""",
    """[1, 2, 3]""",
    """{"name": "Alice", "age": 30}""",
    """{"users": [{"id": 1, "active": true}, {"id": 2, "active": false}]}"""
  )
  jsons.foreach: json =>
    JsonParser.parse(json) match
      case com.codegik.parser.ParseResult.Success(v, _) => println(s"  $json => $v")
      case com.codegik.parser.ParseResult.Failure(m, _) => println(s"  ERROR: $m")
