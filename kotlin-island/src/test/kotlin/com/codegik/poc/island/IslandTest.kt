package com.codegik.poc.island

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IslandTest {

    private val island = Island()


    @Test
    fun dd() {
        val matrix = arrayOf(
            arrayOf(1, 1, 1, 1, 0),
            arrayOf(1, 1, 0, 1, 0),
            arrayOf(1, 0, 0, 0, 0),
            arrayOf(0, 1, 1, 0, 0),
            arrayOf(0, 0, 0, 1, 0)
        );
        assertEquals(3, island.count(matrix))
    }


    @Test
    fun ddd() {
        val matrix = arrayOf(
            arrayOf(1, 1, 1, 1, 0),
            arrayOf(1, 1, 0, 1, 0),
            arrayOf(1, 0, 0, 0, 0),
            arrayOf(0, 1, 1, 0, 0),
            arrayOf(0, 0, 0, 1, 0)
        );
        assertEquals(3, island.diagonalOrder(matrix))
    }

}
