package com.codegik.poc.tax.chain

import com.codegik.poc.tax.StateTax

class Year2023TaxChain : TaxChain(
    2023, listOf(
        StateTax("CA", 0.5),
        StateTax("FL", 1.23)
    )
)