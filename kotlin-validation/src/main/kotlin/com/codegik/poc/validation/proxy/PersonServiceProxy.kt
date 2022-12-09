package com.codegik.poc.validation.proxy

import com.codegik.poc.validation.annotation.ValidatorClass
import com.codegik.poc.validation.domain.Person
import com.codegik.poc.validation.service.PersonService
import com.codegik.poc.validation.validator.Validator
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation

/**
 * TODO
 * - add cache
 */
class PersonServiceProxy(): PersonService() {

    override fun save(person: Person): Person {
        beforeSave(person)
        return super.save(person)
    }

    @Throws(RuntimeException::class)
    fun beforeSave(person: Person): () -> Nothing = {
        PersonService::class.declaredFunctions.first { it.name == "save" }.let {
            person.javaClass.declaredFields.flatMap { field ->
                field.isAccessible = true
                field.annotations.map { annotation ->
                    annotation.annotationClass.findAnnotation<ValidatorClass>().let {validator ->
                        val validator: Validator = validator!!.className.constructors.first().call() as Validator
                        validator.validate(field.get(person), annotation)
                    }
                }.filter { !it.first }
            }.let { throw RuntimeException(it.joinToString()) }
        }
    }
}