package com.codegik.ktor.crud

import com.codegik.ktor.crud.domain.Person
import com.codegik.ktor.crud.plugins.configureDatabase
import com.codegik.ktor.crud.service.PersonService
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class PersonsRestTest {

    @Test
    fun savePerson() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val response = client.post("") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(Person(name = "Ari Toledo", age = 99))
        }

        val result = response.body<Person>()

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Ari Toledo", result.name)
        assertEquals(99, result.age)
        assertNotNull(result.id)
    }

    @Test
    fun updatePerson() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val person = client.get("").body<List<Person>>().first()

        val response = client.put("") {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(person.copy(name = "Other Name"))
        }

        val result = response.body<Person>()

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Other Name", result.name)
        assertEquals(person.age, result.age)
        assertEquals(person.id, result.id)
    }


    @Test
    fun getAllPersons() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val response = client.get("")
        val results = response.body<List<Person>>()

        assertEquals(HttpStatusCode.OK, response.status)

        val expectedNames = listOf("Inacio Klassmann", "John Doe")
        val actualNames = results.map { it.name }

        assertContentEquals(expectedNames, actualNames)
    }

}