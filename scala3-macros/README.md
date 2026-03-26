# Scala 3 Macros

Scala 3 macros enable metaprogramming by executing code at compile time. They use the Quotes API to inspect and generate code, providing zero-runtime-overhead abstractions.

## Overview

This project demonstrates four categories of Scala 3 macros:

1. **Structural Inspection** - Extract type information at compile time
2. **Instrumentation** - Add logging and profiling without manual boilerplate
3. **Typeclass Derivation** - Automatically generate typeclass instances
4. **Compile-time Validation** - Enforce constraints during compilation

## Key Concepts

### inline and Macros

```scala
inline def fieldNames[T]: List[String] = ${ fieldNamesImpl[T] }
```

- `inline` marks a method for inlining at call sites
- `${ ... }` splices in the result of a macro implementation
- The macro runs during compilation, not at runtime

### Quotes API

```scala
def fieldNamesImpl[T: Type](using Quotes): Expr[List[String]] =
  import quotes.reflect.*
  Expr(TypeRepr.of[T].typeSymbol.caseFields.map(_.name))
```

- `Quotes` provides access to the compiler's reflection API
- `Type[T]` represents type information at compile time
- `Expr[A]` represents a typed AST node that will be inserted into the code
- `TypeRepr` allows inspection of type structure

## Structural Inspection (Inspect.scala)

Extract metadata from types at compile time.

### Field Names

```scala
Inspect.fieldNames[Person]  // List("name", "age", "active", "address")
```

Extracts field names from a case class without reflection.

### Field Types

```scala
Inspect.fieldTypes[Person]
// List(("name", "String"), ("age", "Int"), ("active", "Boolean"), ("address", "Address"))
```

Returns field names paired with their type representations.

### toMap

```scala
val alice = Person("Alice", 30, true, Address("123 Main St", "Springfield", "12345"))
Inspect.toMap(alice)
// Map("name" -> "Alice", "age" -> 30, "active" -> true, "address" -> Address(...))
```

Converts a case class instance to a Map using macro-generated field selectors. Each field access is a typed AST node, not a runtime reflection call.

### toJson

```scala
Inspect.toJson(item)
// {"id": 42, "label": "Gadget", "price": 9.99, "stock": 100}
```

Generates specialized JSON serialization code per field type. The macro pattern matches on field types and generates appropriate conversion code at compile time.

### Type Predicates

```scala
Inspect.isCaseClass[Person]              // true
Inspect.requireSubtype[Int, AnyVal]      // compile-time check
```

Validate type properties during compilation.

## Instrumentation (Logging.scala)

Capture information only available at compile time.

### log

```scala
val x = Logging.log(alice.age * 2)
// [LOG Main.scala:83] alice.age.*(2) => 60
```

Prints the source text of the expression, file location, line number, and result.

### time

```scala
val sorted = Logging.time("sort 1M ints") {
  scala.util.Random.shuffle((1 to 1_000_000).toList).sorted
}
// [TIME] sort 1M ints: 245.123 ms
```

Measures wall-clock time of a code block.

### trace

```scala
val result = Logging.trace("expensive", heavyComputation(x, y))
// [TRACE:93] expensive | heavyComputation(x, y) = 42
```

Named trace points showing expression source and value.

### logIf

```scala
inline val debugEnabled = true
Logging.logIf(debugEnabled)(expensive())  // logs the call
Logging.logIf(false)(expensive())         // compiles to: expensive()
```

Conditional logging evaluated at compile time. When false, generates no logging code.

### benchmark

```scala
Logging.benchmark("operation", 100) {
  expensiveComputation()
}
// [BENCH] operation (100 runs): min=2.341 ms  max=3.876 ms  avg=2.654 ms
```

Runs code multiple times and reports timing statistics.

## Typeclass Derivation (Show.scala)

Automatically generate typeclass instances.

```scala
trait Show[A]:
  def show(a: A): String

given Show[Person] = Show.derived[Person]
```

The `derived` macro:
1. Inspects the case class fields via Quotes API
2. Summons Show instances for each field type at compile time
3. Generates an implementation using Product.productIterator

```scala
alice.show
// Person(name = "Alice", age = 30, active = true, address = Address(street = "123 Main St", city = "Springfield", zip = "12345"))
```

No runtime reflection. All type checking happens during compilation.

## Compile-time Validation (Validation.scala)

Enforce constraints on literal values during compilation.

### nonEmpty

```scala
val tag = Validation.nonEmpty("macros")       // OK
val bad = Validation.nonEmpty("")             // compile error
```

### email

```scala
val mail = Validation.email("alice@example.com")  // OK
val bad  = Validation.email("not-an-email")       // compile error
```

### inRange

```scala
val port = Validation.inRange(8080, 1024, 65535)  // OK
val bad  = Validation.inRange(80, 1024, 65535)    // compile error
```

### matchesPattern

```scala
val slug = Validation.matchesPattern("hello-world", "[a-z]+(-[a-z]+)*")  // OK
val bad  = Validation.matchesPattern("Hello", "[a-z]+")                  // compile error
```

### validUrl

```scala
val url = Validation.validUrl("https://scala-lang.org")  // OK
val bad = Validation.validUrl("not a url")               // compile error
```

### assert

```scala
Validation.assert(2 + 2 == 4, "basic arithmetic must hold")  // OK
Validation.assert(1 + 1 == 3, "math is broken")              // compile error
```

## Running the Project

### Run the main program

```bash
sbt run
```

### Run tests

```bash
sbt test
```

## How Macros Work

### Compilation Flow

1. Scala compiler encounters an inline method with a macro splice
2. The macro implementation is executed by the compiler
3. The macro uses Quotes API to inspect types and generate code
4. Generated code is inserted at the call site
5. Normal compilation continues with the expanded code

### Expr and Quotes

```scala
def exampleImpl[T: Type](using Quotes): Expr[String] =
  import quotes.reflect.*
  val typeName = TypeRepr.of[T].show
  Expr(s"Type is: $typeName")
```

- `Expr[A]` is a typed AST fragment
- `Type[T]` captures type parameters
- `Quotes` gives access to compiler internals
- `TypeRepr` represents types for inspection
- `quotes.reflect.*` provides tree manipulation APIs

### Pattern Matching on Types

```scala
TypeRepr.of[T].memberType(field).asType match
  case '[String] => // handle String
  case '[Int]    => // handle Int
  case '[ft]     => // handle any other type ft
```

The macro can generate different code based on the type it encounters.

## Benefits

1. **Zero Runtime Cost** - All work happens at compile time
2. **Type Safety** - Errors caught during compilation, not at runtime
3. **No Reflection** - Generated code uses direct field access
4. **Optimization** - Dead code elimination (logIf example)
5. **Better Errors** - Custom compile-time error messages

## Limitations

1. Macro implementations must be in a different compilation unit from usage
2. Inline parameters must be known at compile time for value-based logic
3. Debugging macro-generated code requires understanding of AST representation
4. Compilation time increases with heavy macro usage

## Further Reading

- [Scala 3 Macros Documentation](https://docs.scala-lang.org/scala3/guides/macros/)
- [Quotes API Reference](https://docs.scala-lang.org/scala3/reference/metaprogramming/macros.html)
- [TASTy Inspection](https://docs.scala-lang.org/scala3/reference/metaprogramming/tasty-inspect.html)
