import munit.FunSuite
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class ComplexSuite extends FunSuite {

  test("test with exception handling") {
    intercept[ArithmeticException] {
      val result = 1 / 0
    }
  }

  test("test with collections") {
    val list = List(1, 2, 3, 4, 5)
    assertEquals(list.filter(_ % 2 == 0), List(2, 4))
  }

  test("test with option") {
    val someValue: Option[Int] = Some(10)
    val noneValue: Option[Int] = None
    assertEquals(someValue.getOrElse(0), 10)
    assertEquals(noneValue.getOrElse(0), 0)
  }

  test("test with future") {
    val futureValue: Future[Int] = Future {
      42
    }
    futureValue.map { result =>
      assertEquals(result, 42)
    }
  }

  test("test with map") {
    val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
    assertEquals(map.get("a"), Some(1))
    assertEquals(map.get("d"), None)
  }
}