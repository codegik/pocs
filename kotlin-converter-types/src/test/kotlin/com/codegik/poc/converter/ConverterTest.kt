package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertEquals

class ConverterTest {


	@Test
	fun convertBigDecimalToString() {
		val converter = BigDecimalConverter()
		val number = BigDecimal("2.000")
		val convertedNumber = "2.000"

		assertEquals(convertedNumber, converter.from(number))
	}


	@Test
	fun convertPersonToFriend() {
		val converter = PersonConverter()
		val person = Person("Inacio", 38)
		val friend = Friend("Inacio", 38)

		assertEquals(friend, converter.from(person))
	}


	@Test
	fun convertList() {
		val converter = PersonConverter()
		val personList = listOf(
			Person("Inacio", 38),
			Person("Gomes", 21),
			Person("Klassmann", 66))

		converter.fromList(personList).onEach {
			println(it)
		}
	}
}
