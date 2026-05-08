import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scalaz._
import Scalaz._

class ScalazPOCSpec extends AnyFlatSpec with Matchers {

  "validateAge" should "accept valid ages" in {
    ScalazPOC.validateAge(18) shouldBe Success(18)
    ScalazPOC.validateAge(25) shouldBe Success(25)
    ScalazPOC.validateAge(100) shouldBe Success(100)
  }

  it should "reject invalid ages" in {
    ScalazPOC.validateAge(17).isFailure shouldBe true
    ScalazPOC.validateAge(0).isFailure shouldBe true
    ScalazPOC.validateAge(-5).isFailure shouldBe true
  }

  "validateName" should "accept valid names" in {
    ScalazPOC.validateName("Alice") shouldBe Success("Alice")
    ScalazPOC.validateName("Bob Smith") shouldBe Success("Bob Smith")
  }

  it should "reject invalid names" in {
    ScalazPOC.validateName("").isFailure shouldBe true
    ScalazPOC.validateName("a" * 51).isFailure shouldBe true
  }

  "createUser" should "create valid users" in {
    val result = ScalazPOC.createUser(1, "Alice", 25)
    result shouldBe Success(User(1, "Alice", 25))
  }

  it should "accumulate validation errors" in {
    val result = ScalazPOC.createUser(1, "", 15)
    result.isFailure shouldBe true
    val errors = result.swap.toOption.get.list
    errors.size shouldBe 2
    errors should contain("Name must be between 1 and 50 characters")
    errors should contain("Age must be 18 or older")
  }

  "divideOption" should "return Some for valid divisions" in {
    ScalazPOC.divideOption(10, 2) shouldBe Some(5)
    ScalazPOC.divideOption(15, 3) shouldBe Some(5)
  }

  it should "return None for division by zero" in {
    ScalazPOC.divideOption(10, 0) shouldBe None
  }

  "chainedDivision" should "work for valid chains" in {
    ScalazPOC.chainedDivision(240) shouldBe Some(10)
  }

  it should "return None when any operation fails" in {
    ScalazPOC.chainedDivision(1) shouldBe None
  }

  "eitherValidation" should "return Right for positive values" in {
    ScalazPOC.eitherValidation(5) shouldBe 5.right
    ScalazPOC.eitherValidation(100) shouldBe 100.right
  }

  it should "return Left for non-positive values" in {
    ScalazPOC.eitherValidation(0).isLeft shouldBe true
    ScalazPOC.eitherValidation(-5).isLeft shouldBe true
  }

  "computeWithLog" should "compute correctly and maintain log" in {
    val (log, result) = ScalazPOC.computeWithLog(5).run
    result shouldBe 20
    log should have size 2
    log(0) should include("Multiplying 5 by 2")
    log(1) should include("Adding 10 to 10")
  }

  "readerConfig" should "build endpoint from config" in {
    val config = Map("host" -> "api.test.com", "port" -> "8443")
    val endpoint = ScalazPOC.readerConfig.run(config)
    endpoint shouldBe "api.test.com:8443"
  }

  it should "use defaults when config is missing" in {
    val endpoint = ScalazPOC.readerConfig.run(Map.empty)
    endpoint shouldBe "localhost:8080"
  }

  "runStateOperations" should "increment state three times" in {
    val (finalState, results) = ScalazPOC.runStateOperations.run(0)
    finalState shouldBe 3
    results should have size 3
  }

  it should "maintain state across operations" in {
    val (finalState, results) = ScalazPOC.runStateOperations.run(10)
    finalState shouldBe 13
    results(0) should include("State was 10, now is 11")
    results(1) should include("State was 11, now is 12")
    results(2) should include("State was 12, now is 13")
  }

  "createAccount" should "create valid accounts" in {
    val result = ScalazPOC.createAccount(1, BigDecimal("1000.50"))
    result shouldBe Success(Account(1, BigDecimal("1000.50")))
  }

  it should "reject negative balances" in {
    val result = ScalazPOC.createAccount(1, BigDecimal("-100"))
    result.isFailure shouldBe true
  }

  "Monoid operations" should "sum lists correctly" in {
    List(1, 2, 3, 4, 5).suml shouldBe 15
  }

  it should "concatenate strings" in {
    List("Hello", "World").intercalate(" ") shouldBe "Hello World"
  }
}
