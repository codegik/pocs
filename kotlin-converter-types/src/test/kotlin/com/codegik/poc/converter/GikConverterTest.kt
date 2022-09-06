package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class GikConverterTest {

	private val converter = GikConverter()


	@Test
	fun testConvert() {
		val neighbor = Neighbor("Jeremy", "Jump", "email@gmail.com")
		val friend = converter.from(neighbor).to(Friend::class)

		assertEquals(friend.name, neighbor.name)
		assertEquals(friend.age, null)
		assertEquals(friend.email, neighbor.aim)

		val person = converter.from(friend).to(Person::class)

		assertEquals(person.name, friend.name)
		assertEquals(person.age, friend.age)
		assertEquals(person.address, friend.email)

		val friend2 = Friend(name = "Joana", age = 23, email = "nomail")
		val person2 = converter.from(friend2).to(Person::class)

		assertEquals(person2.name, friend2.name)
		assertEquals(person2.age, friend2.age)
		assertEquals(person2.address, friend2.email)

	}


	@Test
	fun testConvert1M() {
		val startedAt = System.currentTimeMillis()
		for (i in 0..1000000) {

			val neighbor = Neighbor(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString())
			val friend = converter.from(neighbor).to(Friend::class)
			val person = converter.from(friend).to(Person::class)

			assertEquals(person.name, friend.name)
			assertEquals(person.age, friend.age)
			assertEquals(person.address, friend.email)
		}

		println("GenericConverter took ${System.currentTimeMillis() - startedAt}ms")
	}
}
