package com.codegik.saloon

import com.codegik.saloon.billing.{Bill, BillPreview}
import com.codegik.saloon.customer.Customer
import com.codegik.saloon.membership.{Membership, MembershipFactory}
import com.codegik.saloon.product.Product


class SaloonManagement {
  private var billedCount = 0
  private var openedBillsCount = 0


  def prePay(customer: Customer, products: List[Product]): BillPreview =
    openedBillsCount += 1
    BillPreview(customer, products)


  def pay(billPreview: BillPreview): Bill =
    billedCount += 1
    billPreview.close()


  def printSales() =
    s"""Billed count: $billedCount
       |Open bills count: ${openedBillsCount - billedCount}
       |""".stripMargin


}
