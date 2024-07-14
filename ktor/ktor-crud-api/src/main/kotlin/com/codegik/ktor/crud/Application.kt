package com.codegik.ktor.crud

import com.codegik.ktor.crud.plugins.configureRouting
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.netty.handler.codec.DefaultHeaders

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    DatabaseFactory.init()

    configureRouting()
}
