package com.codegik.ktor.crud

import com.codegik.ktor.crud.plugins.configureDatabase
import com.codegik.ktor.crud.plugins.configureRouting
import com.codegik.ktor.crud.plugins.configureSerialization
import com.codegik.ktor.crud.service.PersonService
import io.ktor.server.application.Application

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureDatabase()
    configureSerialization()
    configureRouting(PersonService())
}
