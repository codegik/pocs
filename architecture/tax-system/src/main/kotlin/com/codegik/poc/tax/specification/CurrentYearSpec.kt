package com.codegik.poc.tax.specification

import com.codegik.poc.tax.Tax
import java.util.*


class CurrentYearSpec: CompositeSpecification<Tax>() {

    override fun isSatisfiedBy(tax: Tax): Boolean {
        return tax.year == Calendar.getInstance().get(Calendar.YEAR)
    }
}