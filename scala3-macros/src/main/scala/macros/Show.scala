package macros

import scala.quoted.*

// ---------------------------------------------------------------------------
// Show typeclass — pretty-prints values
// ---------------------------------------------------------------------------
trait Show[A]:
  def show(a: A): String

extension [A](a: A)(using s: Show[A])
  def show: String = s.show(a)

object Show:

  // ── primitive instances ──────────────────────────────────────────────────
  given Show[Int]     with def show(a: Int): String     = a.toString
  given Show[Long]    with def show(a: Long): String    = a.toString
  given Show[Double]  with def show(a: Double): String  = a.toString
  given Show[Float]   with def show(a: Float): String   = a.toString
  given Show[Boolean] with def show(a: Boolean): String = a.toString
  given Show[String]  with def show(a: String): String  = s""""$a""""
  given Show[Char]    with def show(a: Char): String    = s"'$a'"

  given [A](using sa: Show[A]): Show[Option[A]] with
    def show(a: Option[A]): String = a.fold("None")(v => s"Some(${sa.show(v)})")

  given [A](using sa: Show[A]): Show[List[A]] with
    def show(a: List[A]): String = a.map(sa.show).mkString("List(", ", ", ")")

  given [A, B](using sa: Show[A], sb: Show[B]): Show[(A, B)] with
    def show(p: (A, B)): String = s"(${sa.show(p._1)}, ${sb.show(p._2)})"

  // ── macro-based derivation ───────────────────────────────────────────────
  //
  // At call-site:  given Show[Person] = Show.derived[Person]
  //
  // The macro inspects the case class fields via the Quotes/Reflect API,
  // summons a Show instance for each field type at compile time, and
  // generates an implementation that iterates Product.productIterator at
  // runtime — zero reflection, all type checks happen during compilation.
  //
  inline def derived[T]: Show[T] = ${ derivedImpl[T] }

  def derivedImpl[T: Type](using Quotes): Expr[Show[T]] =
    import quotes.reflect.*

    val sym      = TypeRepr.of[T].typeSymbol
    val typeName = Expr(sym.name)

    if !sym.flags.is(Flags.Case) then
      report.errorAndAbort(
        s"Show.derived only works with case classes/objects, got: ${sym.fullName}"
      )

    val fields = sym.caseFields

    // case object — no fields
    if fields.isEmpty then
      return '{ new Show[T] { def show(t: T): String = $typeName } }

    // For each field, summon Show[FieldType] and produce an (Any => String).
    // The cast is safe: the compiler guarantees field order matches productIterator.
    val showFunctions: List[Expr[Any => String]] = fields.map { field =>
      TypeRepr.of[T].memberType(field).asType match
        case '[ft] =>
          Expr.summon[Show[ft]] match
            case Some(inst) =>
              '{ (a: Any) => $inst.show(a.asInstanceOf[ft]) }
            case None =>
              report.errorAndAbort(
                s"Cannot derive Show[${sym.name}]: " +
                s"missing Show instance for field '${field.name}' " +
                s"of type ${TypeRepr.of[ft].show}"
              )
    }

    val fieldNamesExpr  = Expr(fields.map(_.name))
    val showFunctionsExpr = Expr.ofList(showFunctions)

    '{
      new Show[T]:
        def show(t: T): String =
          val values  = t.asInstanceOf[Product].productIterator.toList
          val labels  = $fieldNamesExpr
          val fns     = $showFunctionsExpr
          val entries = labels.zip(values).zip(fns).map:
            case ((label, value), fn) => s"$label = ${fn(value)}"
          s"${$typeName}(${entries.mkString(", ")})"
    }
