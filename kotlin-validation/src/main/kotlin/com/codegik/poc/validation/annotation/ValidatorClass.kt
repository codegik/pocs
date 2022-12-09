package com.codegik.poc.validation.annotation

import kotlin.reflect.KClass

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class ValidatorClass(val klass: KClass<*>)
