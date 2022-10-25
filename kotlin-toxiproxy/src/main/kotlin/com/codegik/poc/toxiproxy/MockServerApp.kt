package com.codegik.poc.toxiproxy

import com.codegik.poc.toxiproxy.domain.Status
import org.mockserver.client.MockServerClient
import org.mockserver.mock.Expectation
import org.mockserver.model.HttpRequest.request
import org.mockserver.model.HttpResponse.response
import org.mockserver.serialization.ObjectMapperFactory.createObjectMapper
import java.io.IOException
import java.net.HttpURLConnection
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URL
import kotlin.system.exitProcess


fun main() {
    newHealthCheckMock()
    val objectMapper = createObjectMapper()
    val connection = openConnection(URL("http://localhost:8080/health"))
    connection.requestMethod = "GET"
    val response = objectMapper.readValue(connection.inputStream, Status::class.java)
    println("getting response from mock server: ${response.status}")
    exitProcess(1)
}


fun newHealthCheckMock(): Array<out Expectation>? {
    return MockServerClient("localhost", 1080)
        .`when`(
            request()
                .withMethod("GET")
                .withPath("/health")
        )
        .respond(
            response()
                .withStatusCode(200)
                .withBody("{'status': 'OK'}")
        )
}


@Throws(IOException::class)
fun openConnection(url: URL): HttpURLConnection {
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("127.0.01", 1080))
    return url.openConnection(proxy) as HttpURLConnection
}
