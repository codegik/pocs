import org.apache.pekko.actor.typed.{ActorRef, Behavior}
import org.apache.pekko.actor.typed.scaladsl.Behaviors

object UserActor:
  sealed trait Command
  final case class GetUser(id: String, replyTo: ActorRef[Response]) extends Command
  final case class CreateUser(name: String, replyTo: ActorRef[Response]) extends Command

  sealed trait Response
  final case class UserInfo(id: String, name: String) extends Response
  final case class UserCreated(id: String) extends Response
  final case class NotFound(id: String) extends Response

  def apply(): Behavior[Command] =
    Behaviors.setup { context =>
      var users = Map.empty[String, String]
      var nextId = 1

      Behaviors.receiveMessage {
        case GetUser(id, replyTo) =>
          users.get(id) match
            case Some(name) => replyTo ! UserInfo(id, name)
            case None => replyTo ! NotFound(id)
          Behaviors.same

        case CreateUser(name, replyTo) =>
          val id = nextId.toString
          users = users + (id -> name)
          nextId += 1
          replyTo ! UserCreated(id)
          Behaviors.same
      }
    }
