package com.codegik.poc.validation.annotation

import com.codegik.poc.validation.validator.MaxSizeValidator

@Target(AnnotationTarget.FIELD)
@ValidatorClass(MaxSizeValidator::class)
annotation class MaxSize(val size: Int)
