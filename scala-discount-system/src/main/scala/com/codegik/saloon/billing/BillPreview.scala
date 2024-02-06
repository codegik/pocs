package com.codegik.saloon.billing

import com.codegik.saloon.customer.Customer
import com.codegik.saloon.product.Product

class BillPreview(
  private val customer: Customer,
  private val products: List[Product] = List()
) {

  def close() =
    products.foreach(p => customer.increasePurchase())
    customer.updateMembership()
    Bill(customer, products)

}
