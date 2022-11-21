package com.codegik.poc.validation.domain

import com.codegik.poc.validation.annotation.Email
import com.codegik.poc.validation.annotation.MaxSize

data class Person(
    var name: String,
    @MaxSize(size = 100)
    var age: Int,
    @Email
    var email: String
)
