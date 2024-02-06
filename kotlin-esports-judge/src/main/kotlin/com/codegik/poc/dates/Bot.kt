package com.codegik.poc.dates

import kotlin.math.max

class Bot {

    fun top3(botCoord: Array<Array<Int>>): Array<Int> {
        var traps = emptyMap<Int, Int>().toMutableMap()

        botCoord.forEachIndexed { i, e ->
            traps[i] = trap(e)
        }

        val sortedResult = traps.toList().sortedByDescending {
            (_, value) -> value }.toMap()

        return sortedResult.keys.take(3).toTypedArray()
    }

    fun trap(height: Array<Int>): Int {
        var result = 0
        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]

        while (left < right) {
            if (leftMax < rightMax) {
                left++
                leftMax = max(leftMax, height[left])
                result += leftMax - height[left]
            } else {
                right--
                rightMax = max(rightMax, height[right])
                result += rightMax - height[right]
            }
        }

        return result
    }

}
