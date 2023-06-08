package com.codegik.poc.tax.specification

import com.codegik.poc.tax.Tax
import java.util.*


class Last5YearSpec: CompositeSpecification<Tax>() {

    override fun isSatisfiedBy(tax: Tax): Boolean {
        return tax.year >= Calendar.getInstance().get(Calendar.YEAR) - 5
    }
}