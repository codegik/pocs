package com.codegik.saloon

import com.codegik.saloon.billing.BillPreview
import com.codegik.saloon.customer.Customer
import com.codegik.saloon.membership.NoMembership
import com.codegik.saloon.product.{Beer, Coke, FrenchFries, Tea, Water}

import scala.collection.immutable.Map
import scala.collection.mutable.LinkedHashMap

class SaloonManagementTest extends munit.FunSuite {
  val products = List(Beer(), Coke(), FrenchFries(), Water(), Tea())


  test("new customer should be NoMembership") {
    val customer = Customer("Inácio")

    assertEquals(customer.printMembershipName(), "NoMembership")
  }


  test("customer should change membership") {
    val customer = Customer("Inácio")
    val saloonManagement = SaloonManagement()
    val billPreview = saloonManagement.prePay(customer, products ++ products)
    val bill = saloonManagement.pay(billPreview)

    assertEquals(customer.printMembershipName(), "GoldMembership")
  }


  test("customer should change membership considering history purchase") {
    val customer = Customer("Inácio")
    val saloonManagement = SaloonManagement()
    
    val billPreview1 = saloonManagement.prePay(customer, products)
    val bill1 = saloonManagement.pay(billPreview1)

    assertEquals(customer.printMembershipName(), "SilverMembership")

    val billPreview2 = saloonManagement.prePay(customer, products)
    val bill2 = saloonManagement.pay(billPreview2)

    assertEquals(customer.printMembershipName(), "GoldMembership")
  }

}
