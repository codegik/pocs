package com.codegik.ktor.crud.plugins

import com.codegik.ktor.crud.domain.Person
import com.codegik.ktor.crud.service.PersonService
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.JsonConvertException
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.routing

fun Application.configureRouting(personService: PersonService) {

    routing {
        get {
            call.respond(personService.getAll())
        }

        post {
            try {
                val person = call.receive<Person>()
                call.respond(personService.save(person))
            } catch (ex: IllegalStateException) {
                call.respond(HttpStatusCode.BadRequest)
            } catch (ex: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest)
            }
        }

        put {
            try {
                val person = call.receive<Person>()
                call.respond(personService.update(person))
            } catch (ex: IllegalStateException) {
                call.respond(HttpStatusCode.BadRequest)
            } catch (ex: IllegalArgumentException) {
                call.respondText(ex.message.orEmpty(), ContentType.Text.Plain, HttpStatusCode.BadRequest)
            } catch (ex: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
    }
}
