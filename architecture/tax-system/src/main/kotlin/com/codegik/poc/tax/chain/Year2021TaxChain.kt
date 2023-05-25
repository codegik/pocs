package com.codegik.poc.tax.chain

import com.codegik.poc.tax.StateTax

class Year2021TaxChain : TaxChain(
    2021, listOf(
        StateTax("CA", 0.5),
        StateTax("FL", 1.23)
    )
)