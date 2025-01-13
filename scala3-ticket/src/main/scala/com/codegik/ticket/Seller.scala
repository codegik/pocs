package com.codegik.ticket

class Seller(maximumTickets: Int = 10) {
  private val tickets = scala.collection.mutable.Set[Ticket]()

  def sell(owner: String, seat: Int, show: Show): Ticket = {
    if (tickets.size >= maximumTickets) {
      throw new Exception("No more tickets to sell")
    }

    val isSeatInUse = tickets.filter(_.show == show).exists(_.seat == seat)

    if (isSeatInUse) {
      throw new Exception(s"Seat $seat already in use")
    }

    val ticket = Ticket(owner, show, seat)
    tickets.add(ticket)
    ticket
  }

  def totalTickets: Int = tickets.size

}
