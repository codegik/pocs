package com.codegik.poc.tax.specification


class NotSpecification<T>(private val specification: Specification<T>) : CompositeSpecification<T>() {

    override fun isSatisfiedBy(t: T): Boolean {
        return !specification.isSatisfiedBy(t)
    }
}
