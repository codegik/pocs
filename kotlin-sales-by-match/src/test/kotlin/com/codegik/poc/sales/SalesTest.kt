package com.codegik.poc.sales

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SalesTest {

	@Test
	fun pairs2() {
		val sales = Sales()
		val socks = intArrayOf(1, 1, 2, 2)

		assertEquals(2, sales.match(socks))
	}

  @Test
	fun pairs3() {
		val sales = Sales()
		val socks = intArrayOf(1, 2, 1, 2, 1, 3, 2, 2)

		assertEquals(3, sales.match(socks))
	}

	@Test
	fun pairs4() {
		val sales = Sales()
		val socks = intArrayOf(1, 2, 1, 2, 1, 3, 2, 5, 5, 5, 5)

		assertEquals(4, sales.match(socks))
	}
}
