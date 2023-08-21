package com.codegik.keyboarddrive

import java.util.Collections.list

class Purchase {

  def getMoneySpent(budget: Int, keyboards: List[Int], drives: List[Int]): Int = {
    var topAmount = -1

    for (keyboard <- keyboards) {
      for (drive <- drives) {
        val amount = keyboard + drive

        if (amount <= budget && amount > topAmount) {
          topAmount = amount
        }
      }
    }

    return topAmount
  }

}
