package com.codegik.poc.sales

class Sales {

    fun match(socks: IntArray): Int {
        val mappedSocks = mutableMapOf<Int, Int>()
        var countPair = 0

        for (sock in socks) {
            if (!mappedSocks.containsKey(sock)) {
                mappedSocks[sock] = 0
            }

            mappedSocks[sock] = mappedSocks[sock]!! + 1;

            if (mappedSocks[sock]!! % 2 == 0) {
                countPair++
            }
        }

        return countPair
    }
}
