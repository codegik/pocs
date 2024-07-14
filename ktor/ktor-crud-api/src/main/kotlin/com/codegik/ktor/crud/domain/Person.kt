package com.codegik.ktor.crud.domain

import org.jetbrains.exposed.sql.Table

object Person : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name",255)
    var age = integer("age")
    override val primaryKey = PrimaryKey(id)
}