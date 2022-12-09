package com.codegik.poc.validation.service

import com.codegik.poc.validation.domain.Person

open class PersonService {
    private val persons = mutableListOf(
        Person("Inacio", 34, "email1@gmail.com"),
        Person("Gomes", 44, "email2@gmail.com"),
        Person("Klassmann", 12, "email3@gmail.com"),
    )

    open fun save(person: Person): Person {
        persons += person
        return person
    }

    open fun findByName(name: String) = persons.filter { it.name == name }
}