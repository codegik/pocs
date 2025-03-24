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

  test("tail recursive") {
    val size = 1000L
    val list = List.fill(size.toInt)("a")
    val result1 = time(tailRecursiveLength(list))
    val result2 = time(recursiveLength(list))
    assertEquals(result1, size)
    assertEquals(result2, size)
  }

  test("tail recursive should fail due StackOverflowError") {
    val size = 1000000L
    val list = List.fill(size.toInt)("a")
    val result1 = time(tailRecursiveLength(list))
    val result2 = time(recursiveLength(list))
    assertEquals(result1, size)
    assertEquals(result2, size)
  }
}


def time[T](block: => T): T = {
  val before = System.nanoTime
  val result = block
  val after = System.nanoTime
  println("Elapsed time: " + (after - before) / 1000000 + "ms")
  result
}
