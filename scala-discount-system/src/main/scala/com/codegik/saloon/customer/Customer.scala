package com.codegik.saloon.customer

import com.codegik.saloon.membership.{Membership, MembershipFactory, NoMembership}

class Customer(
  private val name: String,
  private var membership: Membership = NoMembership()) {

  private var purchaseCount = 0

  def printName() = s"Sir $name"

  def printMembershipName() = membership.getClass.getSimpleName()

  def increasePurchase() = purchaseCount += 1

  def updateMembership() =
    membership = MembershipFactory.build(purchaseCount)
    membership

}
