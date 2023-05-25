package com.codegik.poc.tax.chain

import com.codegik.poc.tax.StateTax

class Year2022TaxChain : TaxChain(
    2022, listOf(
        StateTax("CA", 0.89),
        StateTax("FL", 1.33)
    )
)
