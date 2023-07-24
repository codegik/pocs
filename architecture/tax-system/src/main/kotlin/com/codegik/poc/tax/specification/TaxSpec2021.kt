package com.codegik.poc.tax.specification

import com.codegik.poc.tax.StateTax

class TaxSpec2021: TaxSpec {

    private val taxes = listOf(
        StateTax("CA", 0.5),
        StateTax("FL", 1.23)
    )

    override fun taxes(): List<StateTax> {
        return taxes
    }

}