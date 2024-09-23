package com.codegik

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.TestPropertySource
import java.io.File
import java.lang.Thread.sleep
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@TestPropertySource("classpath:application.blocking.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BlockingIOTests {

    @LocalServerPort
    var randomServerPort: Int = 0
    val client: HttpClient = HttpClient.newBuilder().build()

    @Value("\${logback.configurationFile}")
    var appName = ""

    @Test
    fun test1MLogsShouldNotContainsLastMessages() {
        val fileName = "logs/application.log"
        val expected = "Generating async log message [10000/10000]"
        val baseUrl = "http://localhost:$randomServerPort"

        File(fileName).writeText("")

        val response = client.send(
            HttpRequest.newBuilder().uri(URI("$baseUrl/log/10000")).GET().build(),
            HttpResponse.BodyHandlers.ofString()
        )

        val fileContent = File(fileName).readText(Charsets.UTF_8)

        assertFalse(fileContent.contains(expected))
        assertEquals(200, response.statusCode())
    }



    @Test
    fun test1MLogsShouldContainsLastMessages() {
        val fileName = "logs/application.log"
        val expected = "Generating async log message [10000/10000]"
        val baseUrl = "http://localhost:$randomServerPort"

        File(fileName).writeText("")

        val response = client.send(
            HttpRequest.newBuilder().uri(URI("$baseUrl/log/10000")).GET().build(),
            HttpResponse.BodyHandlers.ofString()
        )

        sleep(5000)

        val fileContent = File(fileName).readText(Charsets.UTF_8)

        assertTrue(fileContent.contains(expected))
        assertEquals(200, response.statusCode())
    }

}
