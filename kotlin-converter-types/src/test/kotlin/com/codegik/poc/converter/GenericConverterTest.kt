package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenericConverterTest {


	@Test
	fun convertGeneric() {
		val converter = GenericConverter()
		val person = Person("Inacio", 38)
		val friend = converter.from(person).to(Friend::class.java)

		assertEquals(person.name, friend.name)
	}
}
