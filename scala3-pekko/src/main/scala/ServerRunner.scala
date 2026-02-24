import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.http.scaladsl.Http
import scala.concurrent.{Await, ExecutionContextExecutor}
import scala.concurrent.duration.*
import scala.util.{Failure, Success}

object ServerRunner:
  def main(args: Array[String]): Unit =
    given system: ActorSystem[UserActor.Command] = ActorSystem(UserActor(), "user-system")
    given executor: ExecutionContextExecutor = system.executionContext

    val routes = Routes(system)
    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(routes.routes)

    bindingFuture.onComplete {
      case Success(_) => println("Server started successfully on port 8080")
      case Failure(ex) =>
        println(s"Failed to bind to port 8080: ${ex.getMessage}")
        system.terminate()
    }

    sys.addShutdownHook {
      Await.result(bindingFuture.flatMap(_.unbind()), 10.seconds)
      Await.result(system.whenTerminated, 10.seconds)
    }

    Await.result(system.whenTerminated, Duration.Inf)
