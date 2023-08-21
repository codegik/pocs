package com.codegik.keyboarddrive

import scala.collection.immutable.Map
import scala.collection.mutable.LinkedHashMap

class PurchaseTest extends munit.FunSuite {

  test("should result 58 when budget is 60") {
    val result = Purchase().getMoneySpent(60, List(40, 50, 60), List(5, 8, 12))
    val expected = 58

    assertEquals(expected, result)
  }

  test("should result  80 when budget is 80") {
    val result = Purchase().getMoneySpent(80, List(40, 50, 60), List(5, 8, 12, 40, 30))
    val expected = 80

    assertEquals(expected, result)
  }

  test("should result -1 when budget is less than product values") {
    val result = Purchase().getMoneySpent(5, List(40, 50, 60), List(5, 8, 12, 40, 30))
    val expected = -1

    assertEquals(expected, result)
  }

  test("should result -1 when keyboard list is empty") {
    val result = Purchase().getMoneySpent(5, List(), List(5, 8, 12, 40, 30))
    val expected = -1

    assertEquals(expected, result)
  }

  test("should result -1 when drive list is empty") {
    val result = Purchase().getMoneySpent(5, List(1, 0), List())
    val expected = -1

    assertEquals(expected, result)
  }

}
