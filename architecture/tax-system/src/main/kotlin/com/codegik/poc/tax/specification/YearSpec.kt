package com.codegik.poc.tax.specification

import com.codegik.poc.tax.Tax

class YearSpec(val year: Int = 2021): CompositeSpecification<Tax>() {

    override fun isSatisfiedBy(tax: Tax): Boolean {
        return tax.year == year
    }
}