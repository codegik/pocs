package com.codegik.poc

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TextJustificationTest {


	@Test
	fun example1() {
		val textJustification = TextJustification()
		val result = textJustification.justify(
			listOf("This", "is", "an", "example", "of", "text", "justification."), 16
		)
		val expected = listOf(
			"This    is    an",
			"example  of text",
			"justification.  "
		)

		assertEquals(expected, result)
	}

	@Test
	fun example2() {
		val textJustification = TextJustification()
		val result = textJustification.justify(
			listOf("What", "must", "be", "acknowledgment", "shall", "be"), 16
		)
		val expected = listOf(
			"What   must   be",
			"acknowledgment  ",
			"shall be        "
		)

		assertEquals(expected, result)
	}


	@Test
	fun example3() {
		val textJustification = TextJustification()
		val result = textJustification.justify(
			listOf(
				"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
			),
			20
		)
		val expected = listOf(
			"Science  is  what we",
			"understand      well",
			"enough to explain to",
			"a  computer.  Art is",
			"everything  else  we",
			"do                  "
		)

		assertEquals(expected, result)
	}
}




