package com.codegik.poc.converter

interface Converter<From, To> {
    fun from(from: From): To

    fun from(list: List<From>): List<To> {
        return list.map { from(it) }
    }
}