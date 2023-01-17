package com.atm.machine

trait BankMachine {
   def withdraw(amount: Int) : List[Int]
   def totalBalance() : Int
   def bankNotesAsString() : String
}
