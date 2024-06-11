package com.codegik.hibernate.repository

import com.codegik.hibernate.domain.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PersonRepository : CrudRepository<Person, UUID> {

    fun findByAge(age: Int): List<Person>

    fun findByName(name: String): List<Person>

}
