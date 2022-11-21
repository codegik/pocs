package com.codegik.poc.validation.annotation

@Target(AnnotationTarget.FIELD)
annotation class MaxSize(val size: Int)
