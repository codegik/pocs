package com.codegik.poc.validation.annotation

import com.codegik.poc.validation.validator.MaxSizeValidator
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@ValidatorClass(MaxSizeValidator::class)
annotation class MaxSize(val size: Int, val validatorClass: KClass<*> = MaxSizeValidator::class)
