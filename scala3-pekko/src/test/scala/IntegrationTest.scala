import org.apache.pekko.actor.testkit.typed.scaladsl.ActorTestKit
import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.http.scaladsl.model.{HttpRequest, StatusCodes}
import org.apache.pekko.http.scaladsl.unmarshalling.Unmarshal
import org.scalatest.BeforeAndAfterAll
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import scala.compiletime.uninitialized
import scala.concurrent.duration.*
import scala.concurrent.{Await, ExecutionContextExecutor}

class IntegrationTest extends AnyWordSpec with Matchers with BeforeAndAfterAll with ScalaFutures:
  val testKit = ActorTestKit()
  given system: ActorSystem[UserActor.Command] = ActorSystem(UserActor(), "test-system")
  given executor: ExecutionContextExecutor = system.executionContext

  var bindingFuture: Http.ServerBinding = uninitialized

  override def beforeAll(): Unit =
    val routes = Routes(system)
    bindingFuture = Await.result(
      Http().newServerAt("localhost", 8081).bind(routes.routes),
      10.seconds
    )

  override def afterAll(): Unit =
    Await.result(bindingFuture.unbind(), 10.seconds)
    system.terminate()
    Await.result(system.whenTerminated, 10.seconds)
    testKit.shutdownTestKit()

  "The service" should {
    "respond to health check" in {
      val request = HttpRequest(uri = "http://localhost:8081/health")
      val response = Http().singleRequest(request).futureValue

      response.status shouldBe StatusCodes.OK
      val body = Unmarshal(response.entity).to[String].futureValue
      body should include("ok")
    }

    "create and retrieve users" in {
      val createRequest = HttpRequest(uri = "http://localhost:8081/users?name=Alice")
        .withMethod(org.apache.pekko.http.scaladsl.model.HttpMethods.POST)

      val createResponse = Http().singleRequest(createRequest).futureValue
      createResponse.status shouldBe StatusCodes.Created

      val createBody = Unmarshal(createResponse.entity).to[String].futureValue
      createBody should include("id")

      val userId = createBody.split("\"")(3)

      val getRequest = HttpRequest(uri = s"http://localhost:8081/users/$userId")
      val getResponse = Http().singleRequest(getRequest).futureValue

      getResponse.status shouldBe StatusCodes.OK
      val getBody = Unmarshal(getResponse.entity).to[String].futureValue
      getBody should include("Alice")
      getBody should include(userId)
    }

    "return 404 for non-existent users" in {
      val request = HttpRequest(uri = "http://localhost:8081/users/999")
      val response = Http().singleRequest(request).futureValue

      response.status shouldBe StatusCodes.NotFound
    }
  }
