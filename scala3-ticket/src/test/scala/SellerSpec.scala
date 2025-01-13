
import com.codegik.ticket.{Seller, Show}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import java.util.Date
import scala.language.postfixOps

class SellerSpec extends AnyFlatSpec with should.Matchers {

  "A Seller" should "create a ticket" in {
    val seller = Seller()
    val show = Show("The Phantom of the Opera", new Date())
    val ticket = seller.sell("Alice", 1, show)

    ticket.owner should be ("Alice")
  }

  "A Seller" should "notify the seat is already in use" in {
    val seller = Seller()
    val show = Show("The Phantom of the Opera", new Date())
    val seatNumber = 1

    seller.sell("Alice", seatNumber, show)

    intercept[Exception] {
      seller.sell("Josh", seatNumber, show)
    }
  }

  "A Seller" should "create ticket with different seats" in {
    val seller = Seller()
    val show = Show("The Phantom of the Opera", new Date())

    seller.sell("Alice", 1, show)
    seller.sell("Josh", 2, show)

    seller.totalTickets should be (2)
  }

  "A Seller" should "create ticket with same seats but different shows" in {
    val seller = Seller()
    val phantomShow = Show("The Phantom of the Opera", new Date())
    val hamiltonShow = Show("Hamilton", new Date())

    seller.sell("Alice", 1, phantomShow)
    seller.sell("Josh", 1, hamiltonShow)

    seller.totalTickets should be (2)
  }

  "A Seller" should "notify when there is no more tickets to sell" in {
    val seller = Seller(3)
    val phantomShow = Show("The Phantom of the Opera", new Date())
    val hamiltonShow = Show("Hamilton", new Date())

    seller.sell("Josh", 1, hamiltonShow)
    seller.sell("Alice", 1, phantomShow)
    seller.sell("Bob", 2, phantomShow)

    intercept[Exception] {
      seller.sell("Charlie", 3, phantomShow)
    }

    seller.totalTickets should be(3)
  }
}
