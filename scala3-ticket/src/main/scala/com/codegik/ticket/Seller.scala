package com.codegik.ticket

import java.util.concurrent.{ConcurrentHashMap, ConcurrentSkipListSet}
import scala.collection.mutable

class Seller(maximumTickets: Int = 10) {
  private val tickets = mutable.Set[Ticket]()
  private val seats = ConcurrentHashMap[String, ConcurrentSkipListSet[Int]]()

  def sell(owner: String, seat: Int, show: Show): Ticket = {
    if (tickets.size >= maximumTickets) {
      throw new Exception("No more tickets to sell")
    }

    val seatsByShow = seats.computeIfAbsent(show.name, (k) => ConcurrentSkipListSet[Int]())
    val ticket = Ticket(owner, show, seat)

    seatsByShow.add(seat) match {
      case true =>
        seats.put(show.name, seatsByShow)
        tickets.add(ticket)
        ticket
      case false => throw new Exception(s"Seat $seat already in use")
    }
  }

  def totalTickets: Int = tickets.size

}
