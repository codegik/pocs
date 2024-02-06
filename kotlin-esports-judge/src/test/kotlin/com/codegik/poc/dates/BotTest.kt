package com.codegik.poc.dates

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BotTest {

    @Test
    fun calculateTrapShouldSuccess() {
        val coord = arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val result = Bot().trap(coord)
        assertEquals(6, result)
    }

    @Test
    fun getTop3BotsShouldSuccess() {
        val botCoord = arrayOf(
            arrayOf(0, 1, 0, 2, 1, 0),
            arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1),
            arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 1, 0, 1, 3, 2),
            arrayOf(0, 1, 0)
        )
        val result = Bot().top3(botCoord)

        assertEquals(3, result.size)
        assertEquals(2, result[0]) // bot 2 got first place
        assertEquals(1, result[1]) // bot 1 got second place
        assertEquals(0, result[2]) // bot 0 got third place
    }

}
