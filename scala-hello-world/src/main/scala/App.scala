import scala.util.Random

object App {
  def main(args: Array[String]) = {
    println(Student())
    println(Student(2))
    println(Student(2, "Diego"))
    println(Student(name = "Diego"))
    println(Student(name = "Diego").sayHi())
    println(sum(5, 9))
    println(Math.sum(4, 9))
    println(Math.add(20, 30, (x, y) => x + y))
    println(Math.add(20, 30, _ + _))
    println(Math.add(20, 30, _ max _))

    val x: Int = Random.nextInt(10)

    println(x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    })
  }
}

object Math {
  def sum(a: Int, b: Int) = a + b
  def add(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x, y)
}

val sum = (x: Int, y: Int) => x + y

case class Student(var id: Int = 1, var name: String = "Inacio") {
  def sayHi() = "hi"
}