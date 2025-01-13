
import com.codegik.ticket.{Seller, Show, Ticket}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import java.util
import java.util.concurrent.{Callable, Executors}
import java.util.{Date, UUID}
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.jdk.CollectionConverters.*
import scala.language.postfixOps
import scala.util.{Random, Try, Success, Failure}

class SellerConcurrentSpec extends AnyFlatSpec with should.Matchers {

  "A Seller" should "allow the first owner get the ticket" in {
    val executionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(2))
    val random = Random()
    val seller = Seller()
    val show = Show("The Phantom of the Opera", new Date())

    val tasks: util.List[Callable[Future[Ticket]]] = (1 to 10).map(_ =>
      new Callable[Future[Ticket]] {
        override def call(): Future[Ticket] =
          Future(seller.sell(UUID.randomUUID().toString, 3, show))(executionContext)
      }
    ).asJava

    val futures = executionContext.invokeAll(tasks)
    futures.forEach(f => {
      Try(Await.result(f.get(), 10 second)) match {
        case Success(ticket) => println(s"Success to get ticket seat: ${ticket.seat}, owner: ${ticket.owner}")
        case Failure(exception) => println(s"Failed to get ticket seat: ${exception.getMessage}")
      }
    })

    seller.totalTickets should be (1)
  }
}
