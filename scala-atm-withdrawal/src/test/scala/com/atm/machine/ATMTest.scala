package com.atm.machine

import scala.collection.immutable.Map
import scala.collection.mutable.LinkedHashMap

class ATMTest extends munit.FunSuite {

  test("withdraw 400") {
    val atm = ATM(LinkedHashMap(100 -> 4, 50 -> 1, 20 -> 1, 10 -> 1))
    val result = atm.withdraw(400)
    val expected = List(100, 100, 100, 100)

    assertEquals(result, expected)
  }

  test("withdraw 100") {
    val atm = ATM(LinkedHashMap(100 -> 1, 50 -> 0, 20 -> 0, 10 -> 0))
    val result = atm.withdraw(100)
    val expected = List(100)

    assertEquals(result, expected)
  }

  test("withdraw 50") {
    val atm = ATM(LinkedHashMap(100 -> 0, 50 -> 1, 20 -> 0, 10 -> 0))
    val result = atm.withdraw(50)
    val expected = List(50)

    assertEquals(result, expected)
  }

  test("withdraw 480") {
    val atm = ATM(LinkedHashMap(100 -> 4, 50 -> 1, 20 -> 1, 10 -> 1))
    val result = atm.withdraw(480)
    val expected = List(100, 100, 100, 100, 50, 20, 10)

    assertEquals(result, expected)
  }

  test("withdraw 30") {
    val atm = ATM(LinkedHashMap(100 -> 0, 50 -> 0, 20 -> 1, 10 -> 1))
    val result = atm.withdraw(30)
    val expected = List(20, 10)

    assertEquals(result, expected)
  }

  test("withdraw 250") {
    val atm = ATM(LinkedHashMap(100 -> 2, 50 -> 1, 20 -> 1, 10 -> 1))
    val result = atm.withdraw(250)
    val expected = List(100, 100, 50)

    assertEquals(result, expected)
  }

  test("withdraw 250 without banknote 100") {
    val atm = ATM(LinkedHashMap(100 -> 0, 50 -> 3, 20 -> 5, 10 -> 1))
    val result = atm.withdraw(250)
    val expected = List(50, 50, 50, 20, 20, 20, 20, 20)

    assertEquals(result, expected)
  }

  test("withdraw 250 without banknote 100 should fail") {
    val atm = ATM(LinkedHashMap(100 -> 0, 50 -> 3, 20 -> 4, 10 -> 1))
    val expected = "There isn't banknotes enough to withdrawal"
    val caught = intercept[RuntimeException] {
      atm.withdraw(250)
    }
    assertEquals(caught.getMessage, expected)
  }

  test("withdraw 10 twice with notes: 100 -> 1, 50 -> 1, 20 -> 1, 10 -> 1") {
    val atm = ATM(LinkedHashMap(100 -> 1, 50 -> 1, 20 -> 1, 10 -> 1))
    val expected = "There isn't banknotes enough to withdrawal"
    val caught = intercept[RuntimeException] {
      atm.withdraw(10)
      atm.withdraw(10)
    }
    assertEquals(caught.getMessage, expected)
  }

}
