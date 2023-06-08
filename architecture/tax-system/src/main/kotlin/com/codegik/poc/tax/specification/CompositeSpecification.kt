package com.codegik.poc.tax.specification

abstract class CompositeSpecification<T> : Specification<T> {

    fun or(specification: Specification<T>): CompositeSpecification<T> {
        return OrSpecification(this, specification)
    }

    fun and(specification: Specification<T>): CompositeSpecification<T> {
        return AndSpecification(this, specification)
    }

    fun not(): CompositeSpecification<T> {
        return NotSpecification(this)
    }
}
