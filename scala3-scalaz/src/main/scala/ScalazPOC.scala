import scalaz._
import Scalaz._

case class User(id: Int, name: String, age: Int)
case class Account(userId: Int, balance: BigDecimal)

object ScalazPOC {

  def validateAge(age: Int): ValidationNel[String, Int] =
    if (age >= 18) age.successNel
    else "Age must be 18 or older".failureNel

  def validateName(name: String): ValidationNel[String, String] =
    if (name.nonEmpty && name.length <= 50) name.successNel
    else "Name must be between 1 and 50 characters".failureNel

  def validateBalance(balance: BigDecimal): ValidationNel[String, BigDecimal] =
    if (balance >= 0) balance.successNel
    else "Balance cannot be negative".failureNel

  def createUser(id: Int, name: String, age: Int): ValidationNel[String, User] =
    (id.successNel |@| validateName(name) |@| validateAge(age))(User.apply)

  def createAccount(userId: Int, balance: BigDecimal): ValidationNel[String, Account] =
    (userId.successNel |@| validateBalance(balance))(Account.apply)

  def processOption[A](opt: Option[A]): String =
    opt.fold("No value found")(v => s"Found: $v")

  def divideOption(numerator: Int, denominator: Int): Option[Int] =
    if (denominator != 0) (numerator / denominator).some
    else none

  def chainedDivision(start: Int): Option[Int] =
    for {
      a <- divideOption(start, 2)
      b <- divideOption(a, 3)
      c <- divideOption(b, 4)
    } yield c

  def eitherValidation(value: Int): String \/ Int =
    if (value > 0) value.right
    else "Value must be positive".left

  def processEither(value: Int): String =
    eitherValidation(value).fold(
      error => s"Error: $error",
      success => s"Success: $success"
    )

  def multiplyBy2(n: Int): Writer[List[String], Int] =
    Writer(List(s"Multiplying $n by 2"), n * 2)

  def add10(n: Int): Writer[List[String], Int] =
    Writer(List(s"Adding 10 to $n"), n + 10)

  def computeWithLog(n: Int): Writer[List[String], Int] =
    for {
      a <- multiplyBy2(n)
      b <- add10(a)
    } yield b

  def readerConfig: Reader[Map[String, String], String] =
    Reader { config =>
      val host = config.getOrElse("host", "localhost")
      val port = config.getOrElse("port", "8080")
      s"$host:$port"
    }

  def stateOperation: State[Int, String] =
    State { currentState =>
      val newState = currentState + 1
      (newState, s"State was $currentState, now is $newState")
    }

  def runStateOperations: State[Int, List[String]] =
    for {
      r1 <- stateOperation
      r2 <- stateOperation
      r3 <- stateOperation
    } yield List(r1, r2, r3)

  def main(args: Array[String]): Unit = {
    println("=== Scalaz POC with Scala 3 ===\n")

    println("1. Validation (Applicative Functor)")
    val validUser = createUser(1, "Alice", 25)
    val invalidUser = createUser(2, "", 15)
    println(s"Valid user: $validUser")
    println(s"Invalid user: $invalidUser\n")

    println("2. Option Monad")
    println(processOption(Some(42)))
    println(processOption(None))
    println(s"Chained division: ${chainedDivision(240)}")
    println(s"Chained division (fail): ${chainedDivision(1)}\n")

    println("3. Either (\\/) Monad")
    println(processEither(10))
    println(processEither(-5))

    val combined = for {
      a <- eitherValidation(5)
      b <- eitherValidation(10)
    } yield a + b
    println(s"Combined either: $combined\n")

    println("4. Writer Monad (with logging)")
    val (log, result) = computeWithLog(5).run
    println(s"Result: $result")
    println(s"Log: ${log.mkString(" -> ")}\n")

    println("5. Reader Monad (dependency injection)")
    val config = Map("host" -> "api.example.com", "port" -> "443")
    val endpoint = readerConfig.run(config)
    println(s"Endpoint: $endpoint\n")

    println("6. State Monad")
    val (finalState, results) = runStateOperations.run(0)
    println(s"Final state: $finalState")
    println(s"Results: ${results.mkString(", ")}\n")

    println("7. Functor operations")
    val list = List(1, 2, 3, 4, 5)
    val doubled = list.map(_ * 2)
    val filtered = list.filter(_ > 2)
    println(s"Original: $list")
    println(s"Doubled: $doubled")
    println(s"Filtered: $filtered\n")

    println("8. Monoid operations")
    val sum = List(1, 2, 3, 4, 5).suml
    val concatenated = List("Hello", " ", "Scalaz").intercalate(" ")
    println(s"Sum: $sum")
    println(s"Concatenated: $concatenated\n")

    println("9. Applicative composition")
    val validAccount = createAccount(1, BigDecimal("1000.50"))
    val invalidAccount = createAccount(2, BigDecimal("-100"))
    println(s"Valid account: $validAccount")
    println(s"Invalid account: $invalidAccount")
  }
}
