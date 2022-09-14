package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class PerformanceConverterTest {


    @Test
    fun testConvert1M() {
        processAll(1 * 1000 * 1000)
    }

    @Test
    fun testConvert2M() {
        processAll(2 * 1000 * 1000)
    }

    @Test
    fun testConvert3M() {
        processAll(3 * 1000 * 1000)
    }

    @Test
    fun testConvert10M() {
        processAll(10 * 1000 * 1000)
    }

    @Test
    fun testConvert30M() {
        processAll(30 * 1000 * 1000)
    }


    private fun processAll(maxLoop: Long) {
        runGikConverter(maxLoop)
        runGenericConverter(maxLoop)
        runUnsafeConverter(maxLoop)
    }


    private fun runGikConverter(maxLoop: Long) {
        val startedAt = System.currentTimeMillis()
        val gikConverter = GikConverter()

        for (i in 0..maxLoop) {
            val neighbor = Neighbor(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString())
            val friend = gikConverter.from(neighbor).to(Friend::class)
            val person = gikConverter.from(friend).to(Person::class)

            assertEquals(person.name, friend.name)
            assertEquals(person.age, friend.age)
            assertEquals(person.address, friend.email)
        }

        println("GikConverter took ${System.currentTimeMillis() - startedAt}ms to process $maxLoop")
    }


    private fun runGenericConverter(maxLoop: Long) {
        val startedAt = System.currentTimeMillis()
        val genericConverter = GenericConverter()

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


    private fun runUnsafeConverter(maxLoop: Long) {
        val startedAt = System.currentTimeMillis()
        val unsafeConverter = UnsafeConverter()

        for (i in 0..maxLoop) {
            val neighbor = Neighbor(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString())
            val friend = unsafeConverter.from(neighbor).to(Friend::class.java)
            val person = unsafeConverter.from(friend).to(Person::class.java)

            assertEquals(person.name, friend.name)
            assertEquals(person.age, friend.age)
            assertEquals(person.address, friend.email)
        }

        println("UnsafeConverter took ${System.currentTimeMillis() - startedAt}ms to process $maxLoop")
    }
}