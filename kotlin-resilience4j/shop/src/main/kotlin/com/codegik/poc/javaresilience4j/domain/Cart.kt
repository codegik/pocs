package com.codegik.poc.javaresilience4j.domain

data class Cart(var id: String, var products: Array<Chair> = arrayOf())