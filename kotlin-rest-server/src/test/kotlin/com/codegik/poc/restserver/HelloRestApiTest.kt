package com.codegik.poc.restserver

import com.codegik.poc.restserver.server.RestServer
import org.junit.jupiter.api.Test
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.test.assertEquals


class HelloRestApiTest {

	private val rootUrl = "http://localhost:6666"
	private val server = RestServer()


	@Test
	fun callHelloEndpoint() {
		server.start()

		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals("hello world", response.body())
	}

}
