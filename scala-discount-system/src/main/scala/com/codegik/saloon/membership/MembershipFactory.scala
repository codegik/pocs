package com.codegik.saloon.membership

import com.codegik.saloon.membership.Membership

object MembershipFactory {

  def build(purchases: Int): Membership =
    purchases match {
      case p if p >= 20 => PremiumMembership()
      case p if p >= 10 => GoldMembership()
      case p if p >= 5  => SilverMembership()
      case _            => NoMembership()
    }

}
