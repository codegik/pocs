package com.codegik.ktor.cache

import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.http.HttpStatusCode.Companion.NotFound
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.http.HttpStatusCode.Companion.UnprocessableEntity
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class CacheRestTest {

    @Test
    fun getKeyShouldFail() = testApplication {
        val response = client.get("/test")
        assertEquals(NotFound, response.status)
    }

    @Test
    fun saveKeyValueShouldSuccess() = testApplication {
        val key = "test"
        val value = "value1234"
        val response = client.post("/$key/$value")
        assertEquals(OK, response.status)
    }

    @Test
    fun getExistingKeyShouldSuccess() = testApplication {
        val key = "test"
        val value = "value1234"
        val response = client.post("/$key/$value")
        val response2 = client.get("/$key")

        assertEquals(OK, response.status)
        assertEquals(value, response2.body())
    }

    @Test
    fun overrideKeyShouldFail() = testApplication {
        val key = "test"
        val value = "value1234"
        val response = client.post("/$key/$value")
        val response2 = client.post("/$key/$value")

        assertEquals(OK, response.status)
        assertEquals(UnprocessableEntity, response2.status)
    }

    @Test
    fun overrideKeyShouldSuccess() = testApplication {
        val key = "test"
        val value = "value1234"
        val response = client.post("/$key/$value")
        val response2 = client.put("/$key/$value")

        assertEquals(OK, response.status)
        assertEquals(OK, response2.status)
    }

    @Test
    fun deleteKeyShouldSuccess() = testApplication {
        val key = "test"
        val value = "value1234"
        val response = client.post("/$key/$value")
        val response2 = client.delete("/$key")

        assertEquals(OK, response.status)
        assertEquals(OK, response2.status)
    }

    @Test
    fun deleteUnknownKeyShouldFail() = testApplication {
        val response = client.delete("/unknown")
        assertEquals(NotFound, response.status)
    }

}