package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenericConverterTest {

	private val converter = GenericConverter()

	@Test
	fun personToFriend() {
		val person = Person("Inacio", 38)
		val friend = converter.from(person).to(Friend::class.java)

		assertEquals(person.name, friend.name)
		assertEquals(person.age, friend.age)
		assertEquals(person.address, friend.email)
	}

	@Test
	fun friendToPerson() {
		val friend = Friend("Diego", 55, "email@gmail.com")
		val person = converter.from(friend).to(Person::class.java)

		assertEquals(person.name, friend.name)
		assertEquals(person.age, friend.age)
		assertEquals("email@gmail.com", friend.email)
	}

	@Test
	fun friendToFriend() {
		val friend = Friend("Diego", 55, "email@gmail.com")
		val friendClone = converter.from(friend).to(Friend::class.java)

		assertEquals(friendClone.name, friend.name)
		assertEquals(friendClone.age, friend.age)
		assertEquals(friendClone.email, friend.email)
	}
}
