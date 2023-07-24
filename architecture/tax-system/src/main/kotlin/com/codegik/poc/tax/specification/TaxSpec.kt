package com.codegik.poc.tax.specification

import com.codegik.poc.tax.StateTax

interface TaxSpec {
    fun taxes(): List<StateTax>
}