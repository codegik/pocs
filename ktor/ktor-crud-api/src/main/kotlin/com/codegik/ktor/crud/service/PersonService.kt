package com.codegik.ktor.crud.service

import com.codegik.ktor.crud.domain.Person
import com.codegik.ktor.crud.domain.Persons
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.update

class PersonService {

    suspend fun getAll(): List<Person> = newSuspendedTransaction {
        Persons.selectAll().map { toPerson(it) }
    }

    suspend fun save(person: Person): Person = newSuspendedTransaction {
        val id = Persons.insert {
            it[name] = person.name
            it[age] = person.age
        }[Persons.id]

        person.copy(id = id)
    }

    suspend fun update(person: Person): Person = newSuspendedTransaction {
        if (person.id != null) {
            Persons.update {
                it[id] = person.id
                it[name] = person.name
                it[age] = person.age
            }

            person.copy()
        } else {
            throw IllegalArgumentException("missing id field")
        }
    }

    private fun toPerson(row: ResultRow): Person {
        return Person(
            id = row[Persons.id],
            name = row[Persons.name],
            age = row[Persons.age]
        )
    }
}