package com.codegik.poc.validation.annotation

import com.codegik.poc.validation.validator.EmailValidator

@Target(AnnotationTarget.FIELD)
@ValidatorClass(EmailValidator::class)
annotation class Email()
