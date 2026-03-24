package macros

// ---------------------------------------------------------------------------
// Domain models — case classes used across all demos
// ---------------------------------------------------------------------------

case class Address(street: String, city: String, zip: String)
case class Person(name: String, age: Int, active: Boolean, address: Address)
case class Item(id: Int, label: String, price: Double, stock: Option[Int])

// Show instances derived via macro (zero reflection at runtime)
given Show[Address] = Show.derived[Address]
given Show[Person]  = Show.derived[Person]
given Show[Item]    = Show.derived[Item]

// ---------------------------------------------------------------------------
// Demo runner
// ---------------------------------------------------------------------------
@main def run(): Unit =

  val alice = Person("Alice", 30, true, Address("123 Main St", "Springfield", "12345"))
  val bob   = Person("Bob",   25, false, Address("7 Elm Ave",  "Shelbyville", "99999"))
  val item  = Item(42, "Gadget", 9.99, Some(100))
  val rare  = Item(7,  "Rare",   999.0, None)

  // ── 1. Show typeclass via macro derivation ───────────────────────────────
  section("1 · Show — macro-derived typeclass instances")

  println(alice.show)
  println(bob.show)
  println(item.show)
  println(rare.show)

  // ── 2. Structural inspection ─────────────────────────────────────────────
  section("2 · Inspect — compile-time structural extraction")

  println(s"Person field names : ${Inspect.fieldNames[Person]}")
  println(s"Person field count : ${Inspect.fieldCount[Person]}")
  println(s"Person field types : ${Inspect.fieldTypes[Person]}")
  println(s"Product field names: ${Inspect.fieldNames[Product]}")

  println(s"isCaseClass[Person] : ${Inspect.isCaseClass[Person]}")
  println(s"isCaseClass[String] : ${Inspect.isCaseClass[String]}")

  // Macro-generated Map — each field access is a typed AST Select node
  val aliceMap = Inspect.toMap(alice)
  println(s"alice as Map: $aliceMap")

  // Subtype check at compile time (would be a compile error if false)
  Inspect.requireSubtype[Int, AnyVal]
  println("requireSubtype[Int, AnyVal] passed at compile time")

  // ── 3. toJson — type-directed code generation ────────────────────────────
  section("3 · Inspect.toJson — type-directed JSON generation")

  println(Inspect.toJson(alice.address))
  println(Inspect.toJson(item))
  println(Inspect.toJson(rare))

  // ── 4. Compile-time validation ───────────────────────────────────────────
  section("4 · Validation — compile-time constraints")

  val tag   = Validation.nonEmpty("macros")
  val mail  = Validation.email("alice@example.com")
  val port  = Validation.inRange(8080, 1024, 65535)
  val slug  = Validation.matchesPattern("hello-world", "[a-z]+(-[a-z]+)*")
  val url   = Validation.validUrl("https://scala-lang.org")

  println(s"nonEmpty        : $tag")
  println(s"email           : $mail")
  println(s"inRange(8080)   : $port")
  println(s"matchesPattern  : $slug")
  println(s"validUrl        : $url")

  Validation.assert(2 + 2 == 4, "basic arithmetic must hold")
  println("assert(2+2==4) passed at compile time")

  // ── 5. Logging macros ────────────────────────────────────────────────────
  section("5 · Logging — source-aware instrumentation")

  // log captures the *source text* of the expression + call-site position
  val x = Logging.log(alice.age * 2)
  val y = Logging.log(List(1, 2, 3).sum)

  // time wraps a block and reports wall-clock duration
  val sorted = Logging.time("sort 1M ints") {
    scala.util.Random.shuffle((1 to 1_000_000).toList).sorted
  }
  println(s"sorted.head = ${sorted.head}, sorted.last = ${sorted.last}")

  // trace combines a user label with the source text of the expression
  val result = Logging.trace("expensive", List.fill(100)(math.sqrt(2.0)).sum)
  println(s"trace result = $result")

  // logIf — when false, generates NO code (verified by inspecting bytecode)
  val debugEnabled = true
  Logging.logIf(debugEnabled)(alice.name.toUpperCase)
  Logging.logIf(false)(bob.name.toUpperCase)  // this line compiles to nothing

  // benchmark — compile-time iteration count, reports min/max/avg
  Logging.benchmark("string concat", 5) {
    (1 to 1000).foldLeft("")(_ + _.toString)
  }

// ---------------------------------------------------------------------------
// Helpers
// ---------------------------------------------------------------------------
def section(title: String): Unit =
  println(s"\n${"─" * 60}")
  println(s"  $title")
  println("─" * 60)
