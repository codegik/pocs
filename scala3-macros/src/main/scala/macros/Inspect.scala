package macros

import scala.quoted.*

// ---------------------------------------------------------------------------
// Structural inspection macros
//
// All information is extracted from the type at compile time via the
// Quotes/Reflect API — nothing is deferred to runtime reflection.
// ---------------------------------------------------------------------------
object Inspect:

  // ── field names ──────────────────────────────────────────────────────────

  /** Returns the field names of a case class as a compile-time constant list. */
  inline def fieldNames[T]: List[String] = ${ fieldNamesImpl[T] }

  def fieldNamesImpl[T: Type](using Quotes): Expr[List[String]] =
    import quotes.reflect.*
    requireCaseClass[T]
    Expr(TypeRepr.of[T].typeSymbol.caseFields.map(_.name))

  // ── field count ──────────────────────────────────────────────────────────

  /** Returns the number of fields as a compile-time constant. */
  inline def fieldCount[T]: Int = ${ fieldCountImpl[T] }

  def fieldCountImpl[T: Type](using Quotes): Expr[Int] =
    import quotes.reflect.*
    requireCaseClass[T]
    Expr(TypeRepr.of[T].typeSymbol.caseFields.length)

  // ── field types ──────────────────────────────────────────────────────────

  /** Returns (fieldName, typeName) pairs resolved at compile time. */
  inline def fieldTypes[T]: List[(String, String)] = ${ fieldTypesImpl[T] }

  def fieldTypesImpl[T: Type](using Quotes): Expr[List[(String, String)]] =
    import quotes.reflect.*
    val tpe  = TypeRepr.of[T]
    requireCaseClass[T]
    val pairs = tpe.typeSymbol.caseFields.map { field =>
      (field.name, tpe.memberType(field).show)
    }
    Expr(pairs)

  // ── toMap ────────────────────────────────────────────────────────────────

  // The macro generates individual field selectors (e.g., t.name, t.age) as
  // typed AST nodes — no runtime reflection, no string-based lookup.
  /** Converts a case class instance to Map[String, Any] using macro-generated selectors. */
  inline def toMap[T <: Product](t: T): Map[String, Any] = ${ toMapImpl[T]('t) }

  def toMapImpl[T <: Product: Type](t: Expr[T])(using Quotes): Expr[Map[String, Any]] =
    import quotes.reflect.*
    requireCaseClass[T]
    val sym = TypeRepr.of[T].typeSymbol

    // Each entry is generated as a typed Select node pointing to the exact field.
    val entries: List[Expr[(String, Any)]] = sym.caseFields.map { field =>
      val nameExpr  = Expr(field.name)
      val valueExpr = Select.unique(t.asTerm, field.name).asExprOf[Any]
      '{ ($nameExpr, $valueExpr) }
    }

    '{ Map(${ Varargs(entries) }*) }

  // ── toJson ───────────────────────────────────────────────────────────────

  // Unlike a generic JSON library, this macro generates specialised code per
  // field type: strings get quoted & escaped, numbers are converted with
  // .toString, booleans become literals, and nested types are serialised
  // recursively if a Show instance is in scope — all decided at compile time.
  /** Serialises a case class to a JSON string with type-directed code generation. */
  inline def toJson[T <: Product](t: T): String = ${ toJsonImpl[T]('t) }

  def toJsonImpl[T <: Product: Type](t: Expr[T])(using Quotes): Expr[String] =
    import quotes.reflect.*
    requireCaseClass[T]
    val sym = TypeRepr.of[T].typeSymbol

    val fieldExprs: List[Expr[String]] = sym.caseFields.map { field =>
      val keyExpr = Expr(s"\"${field.name}\"")

      TypeRepr.of[T].memberType(field).asType match

        case '[String] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[String]
          '{ $keyExpr + ": \"" + $v.replace("\\", "\\\\").replace("\"", "\\\"") + "\"" }

        case '[Int] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[Int]
          '{ $keyExpr + ": " + $v.toString }

        case '[Long] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[Long]
          '{ $keyExpr + ": " + $v.toString }

        case '[Double] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[Double]
          '{ $keyExpr + ": " + $v.toString }

        case '[Boolean] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[Boolean]
          '{ $keyExpr + ": " + $v.toString }

        case '[Option[String]] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[Option[String]]
          '{ $keyExpr + ": " + $v.fold("null")(s => "\"" + s + "\"") }

        case '[Option[Int]] =>
          val v = Select.unique(t.asTerm, field.name).asExprOf[Option[Int]]
          '{ $keyExpr + ": " + $v.fold("null")(_.toString) }

        case '[ft] =>
          // Fall back to Show if available, otherwise toString
          Expr.summon[Show[ft]] match
            case Some(inst) =>
              val v = Select.unique(t.asTerm, field.name).asExprOf[ft]
              '{ $keyExpr + ": " + $inst.show($v) }
            case None =>
              val v = Select.unique(t.asTerm, field.name).asExprOf[Any]
              '{ $keyExpr + ": " + $v.toString }
    }

    val allFields = Expr.ofList(fieldExprs)
    '{ "{" + $allFields.mkString(", ") + "}" }

  // ── type predicates ──────────────────────────────────────────────────────

  /** Returns true at compile time if T is a case class. */
  inline def isCaseClass[T]: Boolean = ${ isCaseClassImpl[T] }

  def isCaseClassImpl[T: Type](using Quotes): Expr[Boolean] =
    import quotes.reflect.*
    Expr(TypeRepr.of[T].typeSymbol.flags.is(Flags.Case))

  /** Fails compilation if A is not a subtype of B. */
  inline def requireSubtype[A, B]: Unit = ${ requireSubtypeImpl[A, B] }

  def requireSubtypeImpl[A: Type, B: Type](using Quotes): Expr[Unit] =
    import quotes.reflect.*
    if TypeRepr.of[A] <:< TypeRepr.of[B] then '{ () }
    else
      report.errorAndAbort(
        s"${TypeRepr.of[A].show} is not a subtype of ${TypeRepr.of[B].show}"
      )

  // ── helper ───────────────────────────────────────────────────────────────

  private def requireCaseClass[T: Type](using Quotes): Unit =
    import quotes.reflect.*
    val sym = TypeRepr.of[T].typeSymbol
    if !sym.flags.is(Flags.Case) then
      report.errorAndAbort(
        s"This macro only works with case classes, got: ${sym.fullName}"
      )
