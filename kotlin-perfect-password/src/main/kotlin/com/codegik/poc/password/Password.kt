package com.codegik.poc.password

import java.util.Arrays
import kotlin.math.max


class Password {

    fun isPerfectPass(str: String): Boolean {
        // Rule #1 - The length needs to be 32 bits.
        if (str.length != 32) return false;

        // Rule #2 - The character "!" is forbidden.
        if (str.contains('!')) return false;

        // Rule #3 - The character "_" is forbidden.
        if (str.contains('_')) return false;

        // Rule #4 - The password need to have at least 2 Capital letters
        if ("^(?=(?:.*?[A-Z]){2})".toRegex().find(str) == null) return false

        // Rule #5 - The password need to have at least 2 numbers
        if ("^(?=(?:.*?[0-9]){2})".toRegex().find(str) == null) return false

        // Rule #6 - The password need to have at exact 2 special chars (#,*,-,$)
        if ("^(?=(?:.*?[#*-]){2})".toRegex().find(str) == null) return false

        // Rule #7 - The password need to have the longest substring without repeating chars == 26
        if (lengthOfLongestSubstring(str) < 26) return false;

        return true;
    }

    fun lengthOfLongestSubstring(str: String): Int {
        val length = str.length
        var result = 0
        var i = 0
        val lastIndex = IntArray(256)
        Arrays.fill(lastIndex, -1)

        for (j in 0 until length) {
            val code = str[j].code
            i = max(i, lastIndex[code] + 1)
            result = max(result, j - i + 1)
            lastIndex[code] = j
        }

        return result
    }
}
