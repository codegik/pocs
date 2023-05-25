package com.codegik.poc.tax

import com.codegik.poc.tax.map.HistoryTax
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HistoryTaxTest {

	@Test
	fun findTask() {
		val history = HistoryTax()
		val tax = history.find(2021, "CA")

		assertEquals(0.5, tax!!.amount)
	}
}
