package com.codegik.poc.tax

import com.codegik.poc.tax.specification.CurrentYearSpec
import com.codegik.poc.tax.specification.Last5YearSpec
import com.codegik.poc.tax.specification.StateSpec
import com.codegik.poc.tax.specification.YearSpec
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SpecificationTaxTest {
	private val taxes = arrayListOf(
		Tax("CA", 2.45, 2021),
		Tax("FL", 1.22, 2021),
		Tax("CA", 3.33, 2021),
		Tax("AL", 0.34, 2021),
		Tax("CA", 3.49, 2022),
		Tax("FL", 1.29, 2022),
		Tax("CA", 4.39, 2022),
		Tax("AL", 1.39, 2022),
		Tax("AL", 0.88, 2023)
	)


	@Test
	fun findTaxesByYearAndState() {
		val taxesFiltered = taxes.filter { YearSpec(2022).and(StateSpec("AL")).isSatisfiedBy(it) }

		assertEquals(1, taxesFiltered.size)
	}


	@Test
	fun findCurrentYearTaxes() {
		val taxesFiltered = taxes.filter { CurrentYearSpec().isSatisfiedBy(it) }

		assertEquals(1, taxesFiltered.size)
	}


	@Test
	fun findLast5YearsTaxes() {
		val taxesFiltered = taxes.filter { Last5YearSpec().isSatisfiedBy(it) }

		assertEquals(taxes.size, taxesFiltered.size)
	}
}
