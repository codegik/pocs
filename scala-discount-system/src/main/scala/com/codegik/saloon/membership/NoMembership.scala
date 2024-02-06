package com.codegik.saloon.membership

import com.codegik.saloon.membership.Membership

final class NoMembership extends Membership {

  def discount(): BigDecimal = 0.00

}
