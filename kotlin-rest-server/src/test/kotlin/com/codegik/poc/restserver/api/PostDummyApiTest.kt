package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.server.HttpServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostDummyApiTest {

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
	fun shouldFailWhenEndpointIsNotExpectingBody() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello"))
			.POST(BodyPublishers.ofString("body content"))
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(400, response.statusCode())
		assertEquals("number of parameters doesn't match with number of arguments", response.body())
	}


	@Test
	fun shouldSuccessWhenRequestWithoutBody() {
		val response = HttpClient.newHttpClient().send(
			HttpRequest.newBuilder()
				.uri(URI("$rootUrl/hello"))
				.POST(BodyPublishers.noBody())
				.build(), HttpResponse.BodyHandlers.ofString()
		)

		assertEquals(200, response.statusCode())
		assertEquals("hello world!", response.body())
	}


	@Test
	fun shouldSuccessWhenRequestWithBody() {
		val response = HttpClient.newHttpClient().send(
			HttpRequest.newBuilder()
				.uri(URI.create("$rootUrl/hello-with-body"))
				.POST(BodyPublishers.ofString("body content"))
				.build(),
			HttpResponse.BodyHandlers.ofString()
		)

		assertEquals(200, response.statusCode())
		assertEquals("body content", response.body())
	}
}
