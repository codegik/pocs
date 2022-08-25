package com.codegik.poc.converter.domain

import com.codegik.poc.converter.annotation.Alias

data class Neighbor(
    val name: String,
    val lastName: String? = null,
    @Alias("email")
    val aim: String? = null)
