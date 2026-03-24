package macros

import munit.FunSuite

// NOTE: compile-time *failures* cannot be tested with munit — they are
// compilation errors, not exceptions. The tests here verify that valid inputs
// compile and produce the expected values at runtime.
//
// To see a compile-time failure, try adding:
//   Validation.nonEmpty("")              // error: String must not be empty
//   Validation.email("not-an-email")     // error: not a valid e-mail address
//   Validation.inRange(200, 1, 100)      // error: Value 200 is out of range [1, 100]
//   Validation.assert(1 == 2, "bad")     // error: Compile-time assertion failed: bad
//   Validation.matchesPattern("X!", "[a-z]+") // error: "X!" does not match pattern

class ValidationTest extends FunSuite:

  // ── nonEmpty ─────────────────────────────────────────────────────────────

  test("nonEmpty returns the string unchanged") {
    assertEquals(Validation.nonEmpty("hello"), "hello")
  }

  test("nonEmpty preserves whitespace-only strings") {
    // whitespace is not empty — only "" triggers the compile error
    assertEquals(Validation.nonEmpty("  "), "  ")
  }

  test("nonEmpty with single character") {
    assertEquals(Validation.nonEmpty("x"), "x")
  }

  // ── email ─────────────────────────────────────────────────────────────────

  test("email — simple address") {
    assertEquals(Validation.email("alice@example.com"), "alice@example.com")
  }

  test("email — subdomain") {
    assertEquals(Validation.email("user@mail.example.org"), "user@mail.example.org")
  }

  test("email — plus addressing") {
    assertEquals(Validation.email("user+tag@domain.io"), "user+tag@domain.io")
  }

  // ── inRange ───────────────────────────────────────────────────────────────

  test("inRange — value at lower bound") {
    assertEquals(Validation.inRange(1, 1, 100), 1)
  }

  test("inRange — value at upper bound") {
    assertEquals(Validation.inRange(100, 1, 100), 100)
  }

  test("inRange — value in the middle") {
    assertEquals(Validation.inRange(50, 0, 100), 50)
  }

  test("inRange — HTTP port") {
    assertEquals(Validation.inRange(8080, 1024, 65535), 8080)
  }

  test("inRange — negative bounds") {
    assertEquals(Validation.inRange(-5, -10, 0), -5)
  }

  // ── matchesPattern ────────────────────────────────────────────────────────

  test("matchesPattern — digits only") {
    assertEquals(Validation.matchesPattern("12345", "\\d+"), "12345")
  }

  test("matchesPattern — slug format") {
    assertEquals(Validation.matchesPattern("hello-world", "[a-z]+(-[a-z]+)*"), "hello-world")
  }

  test("matchesPattern — alphanumeric") {
    assertEquals(Validation.matchesPattern("abc123", "[a-z0-9]+"), "abc123")
  }

  test("matchesPattern — UUID-like") {
    assertEquals(
      Validation.matchesPattern(
        "550e8400-e29b-41d4-a716-446655440000",
        "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"
      ),
      "550e8400-e29b-41d4-a716-446655440000"
    )
  }

  // ── assert ────────────────────────────────────────────────────────────────

  test("assert — true condition compiles and runs without error") {
    Validation.assert(1 + 1 == 2, "arithmetic")
    Validation.assert(true, "always true")
    Validation.assert(10 > 5, "comparison")
  }

  // ── validUrl ──────────────────────────────────────────────────────────────

  test("validUrl — http") {
    assertEquals(Validation.validUrl("http://example.com"), "http://example.com")
  }

  test("validUrl — https with path") {
    assertEquals(
      Validation.validUrl("https://api.example.com/v1/resource"),
      "https://api.example.com/v1/resource"
    )
  }

  test("validUrl — https with query string") {
    assertEquals(
      Validation.validUrl("https://search.example.com?q=scala"),
      "https://search.example.com?q=scala"
    )
  }

  // ── composed usage ────────────────────────────────────────────────────────

  test("validation macros compose — build a typed config record") {
    // All of these checks happen at compile time.
    // At runtime we just have validated constants.
    val host    = Validation.nonEmpty("localhost")
    val port    = Validation.inRange(9090, 1024, 65535)
    val contact = Validation.email("admin@local.dev")
    val api     = Validation.validUrl("https://api.local.dev/health")

    assertEquals(host,    "localhost")
    assertEquals(port,    9090)
    assertEquals(contact, "admin@local.dev")
    assertEquals(api,     "https://api.local.dev/health")
  }
