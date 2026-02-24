import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.http.scaladsl.Http
import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Main:
  def main(args: Array[String]): Unit =
    given system: ActorSystem[UserActor.Command] = ActorSystem(UserActor(), "user-system")
    given executor: ExecutionContextExecutor = system.executionContext

    val routes = Routes(system)
    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bind(routes.routes)

    println("Server online at http://localhost:8080/")
    println("Press RETURN to stop...")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
