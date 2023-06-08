package com.codegik.poc.tax.specification

import com.codegik.poc.tax.Tax

class StateSpec(val state: String = "CA"): CompositeSpecification<Tax>() {

    override fun isSatisfiedBy(tax: Tax): Boolean {
        return tax.state == state
    }
}