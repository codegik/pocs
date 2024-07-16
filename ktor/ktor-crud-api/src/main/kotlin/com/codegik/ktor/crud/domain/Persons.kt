package com.codegik.ktor.crud.domain

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

object Persons : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name",255)
    var age = integer("age")
    override val primaryKey = PrimaryKey(id)
}

@Serializable
data class Person(val id: Int? = null, val name: String, val age: Int)