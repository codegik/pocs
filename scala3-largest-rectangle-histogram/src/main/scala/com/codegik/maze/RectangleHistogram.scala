package com.codegik.maze

import scala.collection.mutable

class RectangleHistogram {

  def largestArea(heights: Array[Int]): Int = {
    val length = heights.length
    val stack = mutable.Stack[Int]()
    var maxArea = 0
    var i = 0

    while (i <= length) {
      val height = if (i == length) 0 else heights(i)
      if (stack.isEmpty || height >= heights(stack.top)) {
        stack.push(i)
        i += 1
      } else {
        val lastIndex = stack.pop()
        val index = if (stack.isEmpty) i else i - 1 - stack.top
        maxArea = math.max(maxArea, heights(lastIndex) * index)
      }
    }

    maxArea
  }
}