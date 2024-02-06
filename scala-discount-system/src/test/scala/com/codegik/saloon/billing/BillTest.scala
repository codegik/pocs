package com.codegik.saloon.billing

import com.codegik.saloon.SaloonManagement
import com.codegik.saloon.billing.Bill
import com.codegik.saloon.customer.Customer
import com.codegik.saloon.membership.GoldMembership
import com.codegik.saloon.product.Beer

import scala.collection.immutable.Map
import scala.collection.mutable.LinkedHashMap

class BillTest extends munit.FunSuite {


  test("print bill") {
    val customer = Customer("Inácio")
    val products = List(Beer(), Beer(), Beer(), Beer(), Beer(), Beer())
    val saloonManagement = SaloonManagement()
    val billPreview = saloonManagement.prePay(customer, products)
    val bill = saloonManagement.pay(billPreview)

    println(bill.print())
  }


  test("saloon should give 20% of discount to Inácio") {
    val customer = Customer("Inácio")
    val products = List(Beer(), Beer(), Beer(), Beer(), Beer(), Beer())
    val saloonManagement = SaloonManagement()
    val billPreview = saloonManagement.prePay(customer, products)
    val bill = saloonManagement.pay(billPreview)

    assertEquals(BigDecimal(20.00), bill.calculateDiscount())
  }


  test("saloon should give 0% of discount to Inácio") {
    val customer = Customer("Inácio")
    val products = List(Beer(), Beer(), Beer())
    val saloonManagement = SaloonManagement()
    val billPreview = saloonManagement.prePay(customer, products)
    val bill = saloonManagement.pay(billPreview)

    assertEquals(BigDecimal(0.00), bill.calculateDiscount())
  }


  test("Inácio should pay $7.35") {
    val customer = Customer("Inácio")
    val products = List(Beer(), Beer(), Beer()) // sum is 7.35
    val saloonManagement = SaloonManagement()
    val billPreview = saloonManagement.prePay(customer, products)
    val bill = saloonManagement.pay(billPreview)

    assertEquals(BigDecimal(7.35), bill.calculateAmount())
  }

}
