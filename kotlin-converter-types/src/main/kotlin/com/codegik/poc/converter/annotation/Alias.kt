package com.codegik.poc.converter.annotation

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation class Alias(val name: String)
