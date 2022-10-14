
object App {
  def main(args: Array[String]) = {
    println(Student())
    println(Student(2))
    println(Student(2, "Diego"))
    println(Student(name = "Mary"))
    println(Student(name = "Mary").sayHi())

    val students = List(Student(1), Student(2), Student(3))
    println(students.filter { s => s.id > 1 })

    println(Math.sum(5, 9))
    println(sum(5, 9))
    println(Math.add(20, 30, (x, y) => x + y))
    println(Math.add(20, 30, _+_))
    println(Math.add(20, 30, _ max _))
  }
}


val sum = (x: Int, y: Int) => x + y

case class Student(id: Int = 1, name: String = "Inacio") {
  def sayHi() = "hi"
}

object Math {
  def sum(a: Int, b: Int) = a + b

  def add(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x, y)
}