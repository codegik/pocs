package com.codegik.poc.converter

import com.codegik.poc.converter.domain.Neighbor
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JniConverterTest {

	private val converter = JniConverter()

	@Test
	fun testJNI() {
		assertEquals("hey guys!", converter.stringFromJNI)
	}


	@Test
	fun testConvert() {
		val neighbor = Neighbor("Jeremy", "Jump", "email@gmail.com")
		val friend = converter.from(neighbor).to()

		assertEquals("Jeremy", friend)
	}
}
