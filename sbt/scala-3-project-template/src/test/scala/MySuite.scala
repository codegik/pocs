import munit.FunSuite

class MySuite extends FunSuite {
  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }

  test("test case 1") {
    assertEquals(1 + 1, 2)
  }

  test("test case 2") {
    assertEquals(2 * 2, 4)
  }

  test("test case 3") {
    assert(clue(3) > 2)
  }

  test("test case 4") {
    assert(clue(4) < 5)
  }
}
