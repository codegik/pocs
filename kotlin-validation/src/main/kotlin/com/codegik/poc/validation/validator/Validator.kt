package com.codegik.poc.validation.validator

interface Validator {

    fun validate(fieldValue: Any, annotation: Any): Pair<Boolean, String>
}