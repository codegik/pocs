package com.codegik.poc.tax

import com.codegik.poc.tax.specification.TaxFactory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TaxSpecTest {


	@Test
	fun find2023Taxes() {
		val taxes = TaxFactory.getTaxes(2023)

		assertEquals(2, taxes.size)
		assertEquals(2.99, taxes[1].amount)
		assertEquals("FL", taxes[1].state)
	}


	@Test
	fun find2022Taxes() {
		val taxes = TaxFactory.getTaxes(2022)

		assertEquals(2, taxes.size)
		assertEquals(2.23, taxes[1].amount)
		assertEquals("FL", taxes[1].state)
	}


	@Test
	fun find2021Taxes() {
		val taxes = TaxFactory.getTaxes(2021)

		assertEquals(2, taxes.size)
		assertEquals(1.23, taxes[1].amount)
		assertEquals("FL", taxes[1].state)
	}
}
