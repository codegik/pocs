package com.atm.ui

import com.atm.machine.BankMachine
import org.scalajs.dom
import org.scalajs.dom.{HTMLDivElement, HTMLHeadingElement, HTMLInputElement, document}

class UIPresenter(bankMachine: BankMachine) {

  var totalBalanceValue: HTMLHeadingElement = null
  var totalBankNotesValue: HTMLHeadingElement = null
  var withdrawMenu: HTMLInputElement = null
  def present(): Unit = {

    totalBalanceValue = createTotalBalanceSection()

    withdrawMenu = createWithdrawMenu()

    totalBankNotesValue = createTotalBankNotesSection()

  }
  def createTotalBalanceSection(): org.scalajs.dom.HTMLHeadingElement = {
    val totalBalanceColumnsDiv: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]
    totalBalanceColumnsDiv.className = "columns"

    val totalBalanceColumnDiv: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]
    totalBalanceColumnDiv.className = "column is-6 is-offset-3"
    totalBalanceColumnDiv.style = "text-align: center; color: green;"

    val totalBalanceValue: HTMLHeadingElement = document.createElement("h1").asInstanceOf[HTMLHeadingElement]

    document.body.appendChild(totalBalanceColumnsDiv)
    totalBalanceColumnsDiv.appendChild(totalBalanceColumnDiv)
    totalBalanceColumnDiv.appendChild(totalBalanceValue)

    updateTotalBalance(totalBalanceValue, bankMachine.totalBalance())

    totalBalanceValue
  }

  def updateTotalBalance(): Unit = {
    updateTotalBalance(totalBalanceValue, bankMachine.totalBalance())
  }

  def updateTotalBalance(element: HTMLHeadingElement, totalBalance: Int): Unit = {
    element.textContent = "Total balance is: $" + totalBalance.toString
  }

  def createWithdrawMenu(): org.scalajs.dom.HTMLInputElement = {

    val withdrawMenuColumns: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]
    withdrawMenuColumns.className = "columns"

    val withdrawInputDiv: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]
    withdrawInputDiv.className = "column is-4 is-offset-3"

    val withdrawInput: org.scalajs.dom.HTMLInputElement = document.createElement("input").asInstanceOf[org.scalajs.dom.HTMLInputElement]
    withdrawInput.className = "input is-danger is-rounded"
    withdrawInput.`type` = "number"

    val withdrawButtonDiv: org.scalajs.dom.HTMLDivElement = document.createElement("div").asInstanceOf[org.scalajs.dom.HTMLDivElement]
    withdrawButtonDiv.className = "column is-1"

    val withdrawButton: org.scalajs.dom.HTMLButtonElement = document.createElement("button").asInstanceOf[org.scalajs.dom.HTMLButtonElement]
    withdrawButton.className = "button is-danger is-rounded"
    withdrawButton.textContent = "Withdraw Funds."

    document.body.appendChild(withdrawMenuColumns)

    withdrawMenuColumns.appendChild(withdrawInputDiv)
    withdrawInputDiv.appendChild(withdrawInput)

    withdrawMenuColumns.appendChild(withdrawButtonDiv)

    withdrawButton.addEventListener("click", { (e: dom.MouseEvent) =>

      val withdrawColumns: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]

      withdrawColumns.className = "columns"
      val withdrawColumn: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]

      withdrawColumn.className = "column is-6 is-offset-3"
      withdrawColumn.style = "text-align:center; color: green"
      val heading: HTMLHeadingElement = document.createElement("h1").asInstanceOf[HTMLHeadingElement]

      try {
        val bankNotes: List[Int] = bankMachine.withdraw(withdrawInput.value.toInt)
        heading.textContent = "Withdraw finalized with bank notes: " + bankNotes.mkString(" ,")
      } catch {
        case ex: Exception => heading.textContent = "Insufficient Bank Notes to process your withdrawal"
      }

      document.body.appendChild(withdrawColumns)
      withdrawColumns.appendChild(withdrawColumn)
      withdrawColumn.appendChild(heading)

      updateTotalBalance()
      updateBankNotes()

    })
    withdrawButtonDiv.appendChild(withdrawButton)
    withdrawInput
  }

  def createTotalBankNotesSection(): org.scalajs.dom.HTMLHeadingElement = {
    val totalbankNotesColumns: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]
    totalbankNotesColumns.className = "columns"

    val totalbankNotesColumn: HTMLDivElement = document.createElement("div").asInstanceOf[HTMLDivElement]
    totalbankNotesColumn.className = "column is-6 is-offset-3"
    totalbankNotesColumn.style = "text-align: center; color: green;"

    val totalbankNotesPresent: HTMLHeadingElement = document.createElement("h1").asInstanceOf[HTMLHeadingElement]

    document.body.appendChild(totalbankNotesColumns)
    totalbankNotesColumns.appendChild(totalbankNotesColumn)
    totalbankNotesColumn.appendChild(totalbankNotesPresent)

    updateStackedBankNotes(totalbankNotesPresent, bankMachine.bankNotesAsString())

    totalbankNotesPresent
  }

  def updateBankNotes(): Unit = {
    updateStackedBankNotes(totalBankNotesValue, bankMachine.bankNotesAsString())
  }

  def updateStackedBankNotes(element: HTMLHeadingElement, bankNotes: String): Unit = {
    element.textContent = "Bank notes available in ATM: " + bankNotes
  }
}
