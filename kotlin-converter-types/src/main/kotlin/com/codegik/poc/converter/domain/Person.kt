package com.codegik.poc.converter.domain

import com.codegik.poc.converter.annotation.Alias

data class Person(
    val name: String,
    val age: Int,
    @Alias("email")
    val address: String? = null)