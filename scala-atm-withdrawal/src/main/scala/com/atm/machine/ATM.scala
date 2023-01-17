package com.atm.machine

import com.atm.machine.BankMachine

import scala.collection.mutable.{ArrayBuffer, LinkedHashMap}
import scala.util.control.Breaks.{break, breakable}

class ATM(bankNoteList: LinkedHashMap[Int, Int] = LinkedHashMap(100 -> 1, 50 -> 1, 20 -> 1, 10 -> 1)) extends BankMachine {
  var bankNotes = bankNoteList

  override def withdraw(amount: Int): List[Int] = {
    if (amount <= 0) {
      throw IllegalArgumentException("amount must be greater than zero")
    }

    val result = ArrayBuffer[Int]()
    val errorMsg = "There isn't banknotes enough to withdrawal"
    var leftAmount = amount
    var accumulated = 0
    var bankNotesCopy = bankNotes.clone()
    var totalBankNotes = bankNotesCopy.foldLeft(0)(_ + _._2)

    while (amount > accumulated && totalBankNotes > 0) {
      breakable {
        for ((bankNote, available) <- bankNotesCopy) {
          if (available > 0 && leftAmount >= bankNote) {
            accumulated += bankNote
            result += bankNote
            leftAmount = amount - accumulated
            bankNotesCopy = bankNotesCopy.clone().addOne(bankNote, available - 1)
            totalBankNotes = totalBankNotes - 1
            break
          } else if (bankNote == bankNotesCopy.last._1 && available == 0 && leftAmount > 0) {
            throw RuntimeException(errorMsg)
          }
        }
      }
    }

    if (leftAmount > 0) {
      throw RuntimeException(errorMsg)
    }

    bankNotes = bankNotesCopy

    result.toList
  }

  override def totalBalance(): Int = {
    var totalValue = 0
    bankNotes.foreach((k, v) => totalValue = totalValue + (k * v))
    totalValue
  }

  override def bankNotesAsString(): String = {
    bankNotes
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .toList
      .map { case (k, v) => ("$" + k) }
      .mkString("\r\n")
  }
}
