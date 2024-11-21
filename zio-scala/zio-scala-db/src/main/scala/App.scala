import com.codegik.service.{Person, PersonService}
import zio.*
import zio.Console.printLine

object App extends ZIOAppDefault {
  private val personService = new PersonService()

  def run: ZIO[ZIOAppArgs & Scope, Throwable, Unit] =
    for {
      _ <- personService.insert(Person(0, "Inacio", 32))
      people <- personService.getAll
      _ <- printLine(people.mkString("\n"))
    } yield ()
}
