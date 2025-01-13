package com.codegik.ticket

import scala.collection.mutable
import scala.collection.concurrent

class Seller(maximumTickets: Int = 10) {
  private val tickets = mutable.Set[Ticket]()
  private val seats = mutable.Map[String, mutable.Set[Int]]()

  def sell(owner: String, seat: Int, show: Show): Ticket = {
    if (tickets.size >= maximumTickets) {
      throw new Exception("No more tickets to sell")
    }

    val seatsByShow = seats.getOrElse(show.name, mutable.Set())

    seatsByShow.add(seat) match {
      case true =>
        val ticket = Ticket(owner, show, seat)
        seats.put(show.name, seatsByShow)
        tickets.add(ticket)
        ticket
      case false => throw new Exception(s"Seat $seat already in use")
    }
  }

  def totalTickets: Int = tickets.size

}
