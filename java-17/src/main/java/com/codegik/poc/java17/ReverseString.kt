package com.codegik.poc.java17

class ReverseString {

    fun rev(str: String): String {
        var reversed = ""

        for (i in 0..str.length) {
            reversed = str[i] + reversed
        }
        return reversed
    }
}