# scala3-parser-combinators

Parser combinators built from scratch in Scala 3 — no external parsing libraries.

## Core idea

A `Parser[A]` is a function `String => ParseResult[A]`:
- `Success(value, rest)` — parsed value + remaining input
- `Failure(message, rest)` — describes what went wrong

Parsers compose via combinators:

| Combinator | Description |
|---|---|
| `map` | Transform parsed value |
| `flatMap` | Sequence and thread value |
| `or` | Try alternative on failure |
| `~` | Sequence, keep both |
| `<~` / `~>` | Sequence, keep left / right |
| `many` / `many1` | Repeat 0+ / 1+ times |
| `opt` | Optional (wraps in `Option`) |
| `sepBy` | Separated by delimiter |
| `between` | Surrounded by delimiters |

## Demos

**ExprParser** — arithmetic with correct precedence and parentheses:
```
(2 + 3) * 4  =>  20.0
10 / 2 + 3 * 4 - 1  =>  16.0
```

**JsonParser** — subset of JSON (null, bool, number, string, array, object):
```
{"users": [{"id": 1, "active": true}]}
```

## Run

```bash
sbt run
sbt test
```
