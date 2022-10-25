# sbt project compiled with Scala 3

## Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

For more information on the sbt-dotty plugin, see the
[scala3-example-project](https://github.com/scala/scala3-example-project/blob/main/README.md).

## Presentation

### REPL

"hello world"
"hello world'


declaring variables
val s: String = "value"
val s = "value"


mutable and immutable
s = "test"
var x = 10
x = 5


strong typed
x = "test"


interpolation
s"value of $s"
s"value of ${s.length}"


everything is an object or function
5 + 8
5.+(8)


lists
val list = List(1,4,6,8)
for (n <- list) println(n)
list.foreach(n => println(n))

reverse - create new list, don't change original list
list.reverse

remove - remove returns new list, don't change original list
list.drop(2)
list


classes
case class Student()
case class Student(id: Int, name: String)


default values
case class Student(id: Int = 1, name: String = "Inacio")


constructors
println(Student())
println(Student(2))
println(Student(2, "Diego"))
println(Student(name = "Diego"))


functions
case class Student(var id: Int = 1, var name: String = "Inacio") {
    def sayHi() = "hi"
}
println(Student(name = "Diego").sayHi())


anonymous functions
val sum = (x: Int, y: Int) => x + y
println(sum(5, 9))


filter
val students = List(Student(1), Student(2), Student(3))
println(students.filter { s => s.id > 1 })

objects - don't need to instantiate, like static classes
object Math {
    def sum(a: Int, b: Int) = a + b
}
println(Math.sum(4, 9))


fun functions - add to Math
def add(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x, y)
println(Math.add(20, 30, (x, y) => x + y))
println(Math.add(20, 30, _ + _))
println(Math.add(20, 30, _ max _))


pattern matching
val x: Int = Random.nextInt(10)

println(x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
})