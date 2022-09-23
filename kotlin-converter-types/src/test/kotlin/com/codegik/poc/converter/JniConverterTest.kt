package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Friend
import com.codegik.poc.converter.domain.Neighbor
import com.codegik.poc.converter.domain.Person
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class JniConverterTest {

	private val converter = JniConverter()


	@Test
	fun testConvert() {
		val neighbor = Neighbor("Jeremy", "Jump", "email@gmail.com")
		val friend = converter.from(neighbor).to(Friend::class.java)

		println(friend)
	}
}
