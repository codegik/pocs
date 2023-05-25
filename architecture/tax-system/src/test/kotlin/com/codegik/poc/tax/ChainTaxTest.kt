package com.codegik.poc.tax

import com.codegik.poc.tax.chain.Year2021TaxChain
import com.codegik.poc.tax.chain.Year2022TaxChain
import com.codegik.poc.tax.chain.Year2023TaxChain
import com.codegik.poc.tax.chain.Year2024TaxChain
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainTaxTest {

	@Test
	fun findTask() {
		val taxChain = Year2024TaxChain()
			.next(Year2023TaxChain()
				.next(Year2022TaxChain()
					.next(Year2021TaxChain())))

		val tax = taxChain.find(2023, "CA")

		assertEquals(0.5, tax!!.amount)
	}
}
