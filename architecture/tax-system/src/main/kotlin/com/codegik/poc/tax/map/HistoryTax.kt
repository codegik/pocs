package com.codegik.poc.tax.map

import com.codegik.poc.tax.StateTax

class HistoryTax {
    private val history = hashMapOf<Int, List<StateTax>>()

    init {
        history[2021] = listOf(
            StateTax("CA", 0.5),
            StateTax("FL", 1.23)
        )
        history[2022] = listOf(
            StateTax("CA", 0.89),
            StateTax("FL", 1.33)
        )
        history[2023] = listOf(
            StateTax("CA", 0.98),
            StateTax("FL", 1.45)
        )
    }

    fun find(year: Int, state: String): StateTax? {
        return history[year]?.first { it.state == state }
    }
}