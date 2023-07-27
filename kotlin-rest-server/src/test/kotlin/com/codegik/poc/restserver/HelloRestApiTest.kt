package com.codegik.poc.restserver

import com.codegik.poc.restserver.server.HttpServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HelloRestApiTest {

	private val rootUrl = "http://localhost:9999"
	private val server = HttpServer(9999)

	@BeforeAll
	fun before() {
		server.start()
	}

	@AfterAll
	fun after() {
		server.stop()
	}


	@Test
	fun shouldSuccessWhenGetRequest() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertEquals("hello world!", response.body())
	}


	@Test
	fun shouldFailDueMethodCallNoiSupported() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello"))
			.DELETE()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(505, response.statusCode())
		assertEquals("Invalid http request protocol", response.body())
	}


	@Test
	fun shouldFailDueWrongEndpoint() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello-there"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(404, response.statusCode())
		assertEquals("Not found", response.body())
	}

}
