package com.codegik.ktor.crud.plugins

import com.codegik.ktor.crud.domain.Persons
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    val config = HikariConfig()
    config.driverClassName = "org.h2.Driver"
    config.jdbcUrl = "jdbc:h2:mem:test"
    config.maximumPoolSize = 3
    config.isAutoCommit = false
    config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    config.validate()

    Database.connect(HikariDataSource(config))

    transaction {
        create(Persons)
        Persons.insert {
            it[name] = "Inacio Klassmann"
            it[age] = 34
        }
        Persons.insert {
            it[name] = "John Doe"
            it[age] = 76
        }
    }

}