package com.codegik.saloon.membership

import com.codegik.saloon.membership.Membership

final class PremiumMembership extends Membership {

  def discount(): BigDecimal = 20.00

}
