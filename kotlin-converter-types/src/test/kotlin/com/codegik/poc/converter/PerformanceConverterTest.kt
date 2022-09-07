package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class PerformanceConverterTest {
    private val gikConverter = GikConverter()
    private val genericConverter = GenericConverter()



    @Test
    fun testConvert1M() {
        process(1 * 1000 * 1000)
    }

    @Test
    fun testConvert10M() {
        process(10 * 1000 * 1000)
    }

    @Test
    fun testConvert100M() {
        process(100 * 1000 * 1000)
    }


    @Test
    fun testConvert1B() {
        process(1000 * 1000 * 1000)
    }



    private fun process(maxLoop: Long) {
        var startedAt = System.currentTimeMillis()

        for (i in 0..maxLoop) {
            val neighbor = Neighbor(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString())
            val friend = gikConverter.from(neighbor).to(Friend::class)
            val person = gikConverter.from(friend).to(Person::class)

            assertEquals(person.name, friend.name)
            assertEquals(person.age, friend.age)
            assertEquals(person.address, friend.email)
        }

        println("GikConverter took ${System.currentTimeMillis() - startedAt}ms to process $maxLoop")


        startedAt = System.currentTimeMillis()

        for (i in 0..maxLoop) {
            val neighbor = Neighbor(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString())
            val friend = genericConverter.from(neighbor).to(Friend::class.java)
            val person = genericConverter.from(friend).to(Person::class.java)

            assertEquals(person.name, friend.name)
            assertEquals(person.age, friend.age)
            assertEquals(person.address, friend.email)
        }

        println("GenericConverter took ${System.currentTimeMillis() - startedAt}ms to process $maxLoop")
    }
}