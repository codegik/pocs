package com.codegik.poc.tax.specification

class OrSpecification<T>(
    private val left: Specification<T>,
    private val right: Specification<T>) : CompositeSpecification<T>(), Specification<T> {

    override fun isSatisfiedBy(t: T): Boolean {
        return left.isSatisfiedBy(t) || right.isSatisfiedBy(t)
    }
}
