package com.codegik.ktor.cache.plugins

import com.codegik.ktor.cache.service.CacheService
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.NotFound
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.http.HttpStatusCode.Companion.UnprocessableEntity
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    val cache = CacheService()

    routing {
        get("/{key?}") {
            val key = call.parameters["key"] ?: return@get call.respond(BadRequest)

            cache.get(key)?.let { call.respond(OK, it) } ?: call.respond(NotFound)
        }

        post("/{key?}/{value?}") {
            val key = call.parameters["key"] ?: return@post call.respond(BadRequest)
            val value = call.parameters["value"] ?: return@post call.respond(BadRequest)

            if (cache.add(key, value)) {
                call.respond(OK)
            } else {
                call.respond(UnprocessableEntity)
            }
        }

        put("/{key?}/{value?}") {
            val key = call.parameters["key"] ?: return@put call.respond(BadRequest)
            val value = call.parameters["value"] ?: return@put call.respond(BadRequest)

            if (cache.update(key, value)) {
                call.respond(OK)
            } else {
                call.respond(UnprocessableEntity)
            }
        }

        delete("/{key?}") {
            val key = call.parameters["key"] ?: return@delete call.respond(BadRequest)

            if (cache.delete(key)) {
                call.respond(OK)
            } else {
                call.respond(NotFound)
            }
        }
    }
}
