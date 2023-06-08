package com.codegik.poc.tax.specification

interface Specification<T> {
    fun isSatisfiedBy(t: T): Boolean
}
