package com.codegik.maze

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class RectangleHistogramSpec extends AnyFlatSpec with should.Matchers {

  it should "It should result in 10" in {
    val heights = Array(2, 1, 5, 6, 2, 3)
    val rectangle = RectangleHistogram()
    val result = rectangle.largestArea(heights)

    result should be (10)
  }

  it should "It should result in 4" in {
    val heights = Array(2, 4)
    val rectangle = RectangleHistogram()
    val result = rectangle.largestArea(heights)

    result should be (4)
  }

}


