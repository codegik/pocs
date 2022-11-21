package com.codegik.poc.validation.proxy

import com.codegik.poc.validation.annotation.Email
import com.codegik.poc.validation.annotation.MaxSize
import com.codegik.poc.validation.annotation.Validate
import com.codegik.poc.validation.domain.Person
import com.codegik.poc.validation.service.PersonService
import com.codegik.poc.validation.validator.Validator
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.hasAnnotation

class PersonServiceProxy(): PersonService() {

    private val validator = Validator()

    override fun save(person: Person): Person {
        beforeSave(person)
        return super.save(person)
    }

    fun beforeSave(person: Person) = run {
        PersonService::class.declaredFunctions.first { it.name == "save" }.hasAnnotation<Validate>().let {
            val errors = person.javaClass.declaredFields.map { field ->
                field.annotations.map { annotation ->
                    when (annotation.annotationClass) {
                        Email::class    -> validator.checkEmail(field.get(person))
                        MaxSize::class  -> validator.checkMaxSize(field.get(person), annotation as MaxSize)
                        else            -> Pair(true, "ok")
                    }
                }.filter {
                    it.first == false
                }
            }
            errors.map { error ->
                val result = error.toString()

            }
        }
    }
}