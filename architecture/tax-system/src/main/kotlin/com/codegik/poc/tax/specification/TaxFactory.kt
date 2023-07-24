package com.codegik.poc.tax.specification

import com.codegik.poc.tax.StateTax

object TaxFactory {

    fun getTaxes(year: Int): List<StateTax> {
        return when(year) {
            2021 -> TaxSpec2021().taxes()
            2022 -> TaxSpec2022().taxes()
            2023 -> TaxSpec2023().taxes()
            else -> TaxSpec2023().taxes()
        }
    }
}