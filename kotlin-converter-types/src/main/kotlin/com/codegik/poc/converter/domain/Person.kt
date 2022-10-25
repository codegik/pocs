package com.codegik.poc.converter.domain

import com.codegik.poc.converter.annotation.Alias

class Person(
    var name: String? = null,
    var age: Int? = 1,
    @Alias("email")
    var address: String? = null)