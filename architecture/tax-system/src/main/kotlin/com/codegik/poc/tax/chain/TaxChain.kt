package com.codegik.poc.tax.chain

import com.codegik.poc.tax.StateTax

abstract class TaxChain(private var year: Int, private var taxes: List<StateTax>) {
    private lateinit var chain: TaxChain

    fun find(year: Int, state: String): StateTax? {
        if (this.year == year) {
            return taxes.first { it.state == state }
        }

        return chain.find(year, state)
    }

    fun next(taxChain: TaxChain): TaxChain {
        this.chain = taxChain
        return this
    }
}