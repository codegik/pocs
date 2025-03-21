import munit.FunSuite


class MySuite extends FunSuite {
  test("currying test") {
    assertEquals(sum(3, add(5)), 8)
    assertEquals(add(3)(5), 8)
    assertEquals(addThree(3)(5)(2), 10)
  }

  test("partial application test") {
    assertEquals(sum(3, multiply(5)), 15)

    val multiplyFunc = multiply(3)
    assertEquals(multiplyFunc(5), 15)
    assertEquals(multiplyFunc(3), 9)

    val result = multiply(3)(5)
    assertEquals(result, 15)
  }

}
