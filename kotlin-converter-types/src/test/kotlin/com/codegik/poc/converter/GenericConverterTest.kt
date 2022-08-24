package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenericConverterTest {


	@Test
	fun convertGeneric() {
		val converter = GenericConverter()
		val person1 = Person("Inacio", 38)
		val friend1 = converter.from(person1).to(Friend::class.java)

		assertEquals(person1.name, friend1.name)
		assertEquals(person1.age, friend1.age)

		val friend2 = Friend("Diego", 55, "email@gmail.com")
		val person2 = converter.from(friend2).to(Person::class.java)

		assertEquals(person2.name, friend2.name)
		assertEquals(person2.age, friend2.age)
		assertEquals("email@gmail.com", friend2.email)
	}
}
