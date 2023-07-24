package com.codegik.poc.tax.specification

import com.codegik.poc.tax.StateTax

class TaxSpec2022: TaxSpec {

    private val taxes = listOf(
        StateTax("CA", 1.5),
        StateTax("FL", 2.23)
    )

    override fun taxes(): List<StateTax> {
        return taxes
    }

}