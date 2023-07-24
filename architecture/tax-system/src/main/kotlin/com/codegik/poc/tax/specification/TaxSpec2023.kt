package com.codegik.poc.tax.specification

import com.codegik.poc.tax.StateTax

class TaxSpec2023: TaxSpec {

    private val taxes = listOf(
        StateTax("CA", 1.9),
        StateTax("FL", 2.99)
    )

    override fun taxes(): List<StateTax> {
        return taxes
    }

}