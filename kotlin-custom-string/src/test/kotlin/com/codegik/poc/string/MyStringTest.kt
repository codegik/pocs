package com.codegik.poc.string

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MyStringTest {

	@Test
	fun length() {
		assertEquals(1, MyString("e").length())
	}

	@Test
	fun toArray() {
		val result = MyString("e").toArray()
		val expected = charArrayOf('e')
		assertEquals(expected.size, result.size)
		assertEquals(expected[0], result[0])
	}

	@Test
	fun isEmpty() {
		assertTrue(MyString("").isEmpty())
		assertTrue(MyString("  ").isEmpty())
	}

	@Test
	fun charAt() {
		assertEquals('a', MyString("ae").charAt(0))
		assertEquals('e', MyString("ae").charAt(1))
	}

	@Test
	fun iterator() {
		val myString = MyString("hey dude")
		val iterator = myString.iterator()
		var index = 0

		while (iterator.hasNext()) {
			assertEquals(myString.charAt(index), iterator.next())
			index++
		}
	}

	@Test
	fun indexOf() {
		assertEquals(0, MyString("ae").indexOf('a'))
		assertEquals(1, MyString("ae").indexOf('e'))
	}

	@Test
	fun foreach() {
		var result = ""
		val expected = "test"

		MyString(expected).foreach {
			result += it
		}

		assertEquals(expected, result)
	}

	@Test
	fun reverse() {
		assertEquals("qwert", MyString("trewq").reverse())
	}

	@Test
	fun hashCodeValidation() {
		assertEquals(108003713, MyString("qwert").hashCode())
		assertEquals(MyString("qwert").hashCode(), MyString("qwert").hashCode())
	}

	@Test
	fun equals() {
		assertEquals(MyString("qwert"), MyString("qwert"))
		assertTrue(MyString("qwert") == MyString("qwert"))
		assertTrue(MyString("qwert").equals(MyString("qwert")))
	}

	@Test
	fun replace() {
		assertEquals(MyString("wwert"), MyString("qwert").replace('q', 'w'))
		assertEquals(MyString("wwwrt"), MyString("qwert").replace('q', 'w').replace('e', 'w'))
	}
}
