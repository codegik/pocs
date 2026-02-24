import org.apache.pekko.actor.typed.{ActorRef, ActorSystem}
import org.apache.pekko.actor.typed.scaladsl.AskPattern.*
import org.apache.pekko.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import org.apache.pekko.http.scaladsl.server.Directives.*
import org.apache.pekko.http.scaladsl.server.Route
import org.apache.pekko.util.Timeout
import scala.concurrent.duration.*

class Routes(userActor: ActorRef[UserActor.Command])(using system: ActorSystem[?]):
  given timeout: Timeout = 3.seconds

  val routes: Route =
    concat(
      path("health") {
        get {
          complete(HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}"""))
        }
      },
      pathPrefix("users") {
        concat(
          pathEnd {
            post {
              parameter("name") { name =>
                val response = userActor.ask(ref => UserActor.CreateUser(name, ref))
                onSuccess(response) {
                  case UserActor.UserCreated(id) =>
                    complete(StatusCodes.Created, HttpEntity(ContentTypes.`application/json`, s"""{"id":"$id"}"""))
                }
              }
            }
          },
          path(Segment) { id =>
            get {
              val response = userActor.ask(ref => UserActor.GetUser(id, ref))
              onSuccess(response) {
                case UserActor.UserInfo(userId, name) =>
                  complete(HttpEntity(ContentTypes.`application/json`, s"""{"id":"$userId","name":"$name"}"""))
                case UserActor.NotFound(_) =>
                  complete(StatusCodes.NotFound)
              }
            }
          }
        )
      }
    )
