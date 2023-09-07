package com.codegik.poc.restserver.api

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
class GetDummyApiTest {

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
	fun shouldSuccessWhenRequestEndpoint() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertEquals("hello world!", response.body())
	}


	@Test
	fun shouldSuccessWhenRequestEndpointWithOnePathVariable() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello/Inácio"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertEquals("hello In%C3%A1cio!", response.body())
	}


	@Test
	fun shouldSuccessWhenRequestEndpointWithTwoPathVariable() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello/Inácio/klassmann"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertEquals("hello In%C3%A1cio klassmann!", response.body())
	}


	@Test
	fun shouldSuccessWhenRequestEndpointWithOnePathVariablePlusPash() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello/Inácio/my/friend"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertEquals("hello In%C3%A1cio my friend!", response.body())
	}


	@Test
	fun shouldSuccessWhenRequestEndpointWithTwoPathVariablePlusPash() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello/Inácio/klassmann/my/friend"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(200, response.statusCode())
		assertEquals("hello In%C3%A1cio klassmann my friend!", response.body())
	}


	@Test
	fun shouldFailWhenRequestEndpointNotMapped() {
		val request = HttpRequest.newBuilder()
			.uri(URI("$rootUrl/hello/Inácio/Gomes/klassmann/my/friend"))
			.GET()
			.build()

		val response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString())

		assertEquals(404, response.statusCode())
	}

}
