package com.codegik.poc.converter

import java.math.BigDecimal

class BigDecimalConverter: Converter<BigDecimal, String> {
    override fun from(from: BigDecimal): String {
        return from.toPlainString()
    }
}