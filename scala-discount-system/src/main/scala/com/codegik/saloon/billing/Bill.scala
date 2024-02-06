package com.codegik.saloon.billing

import com.codegik.saloon.customer.Customer
import com.codegik.saloon.membership.NoMembership
import com.codegik.saloon.product.Product

class Bill(
  private val customer: Customer,
  private val products: List[Product]
) {

  private def invoice = new scala.util.Random().between(0, Integer.MAX_VALUE)
  private def membership = customer.updateMembership()


  def calculateAmount(): BigDecimal = products.map(p => p.price()).sum


  def calculateDiscount(): BigDecimal =
    if (membership.isInstanceOf[NoMembership]) {
      membership.discount()
    } else {
      membership.discount() + BigDecimal(10.00)
    }


  def print(): String =
    val productText = products.map(p => s"+ ${p.description()} $$${p.price()}").mkString("\n")
    val amount = calculateAmount()
    val discount = calculateDiscount()
    val discountAmount = amount * discount / 100

    s"""
       |Bill #$invoice -> ${customer.printName()} (${customer.printMembershipName()})
       |
       |Product purchase list
       |$productText
       |
       |Amount: $$$amount
       |Discount: $$$discountAmount ($discount%)
       |Total bill: ${amount - discountAmount}
       |
       |See you soon ${customer.printName()}
       |""".stripMargin

}
