package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.http.HttpHeader.CONNECTION
import com.codegik.poc.restserver.http.HttpHeader.CONTENT_LENGTH
import com.codegik.poc.restserver.http.HttpHeader.CONTENT_TYPE
import com.codegik.poc.restserver.http.HttpHeader.HTTP_VERSION
import com.codegik.poc.restserver.http.HttpMethod
import com.codegik.poc.restserver.http.HttpMethod.POST
import com.codegik.poc.restserver.http.HttpRequest
import com.codegik.poc.restserver.http.HttpResponse
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class RequestDispatcher(private val clientSocket: Socket) {
    private lateinit var input: BufferedReader
    private lateinit var output: PrintWriter


    fun process(): Boolean {
        val httpRequest: HttpRequest
        val request = readRequest()

        println("Received request")
        println(request)

        try {
            httpRequest = parseRequest(request)
        } catch (e: Exception) {
            val message = "Invalid http request protocol"
            val headers = mapOf(
                CONTENT_TYPE to "text/plain;charset=utf-8",
                CONTENT_LENGTH to (message.length + 1).toString(),
                CONNECTION to "close")

            println(message)
            writeResponse(HttpResponse(headers = headers, status = "505", body = message))
            close()

            return false
        }

        writeResponse(processRequest(httpRequest))

        return close()
    }


    private fun processRequest(httpRequest: HttpRequest): HttpResponse {
        val body = "hey man"
        val headers = mapOf(
            CONTENT_TYPE to "text/plain;charset=utf-8",
            CONTENT_LENGTH to (body.length + 1).toString(),
            CONNECTION to "close")

        return HttpResponse(headers = headers, status = "200", body = body)
    }


    @Throws(Exception::class)
    private fun parseRequest(requestText: String): HttpRequest {
        val lines = requestText.split("\n")
        val (method, endpoint, version) = lines[0].split(" ")
        val body = if (method == POST.name) lines.last() else ""
        val headers = mutableMapOf<String, String>()

        for (line in lines.subList(1, lines.size - 1)) {
            val (key, value) = line.split(":")
            headers[key.trim()] = value.trim()
        }

        return HttpRequest(headers = headers, endpoint = endpoint, method = HttpMethod.valueOf(method), body = body)
    }


    private fun writeResponse(httpResponse: HttpResponse): Boolean {
        output.println("$HTTP_VERSION ${httpResponse.status}")
        httpResponse.headers.forEach { output.println("${it.key}: ${it.value}") }
        output.println("")
        output.println(httpResponse.body);
        output.flush()

        return true
    }


    private fun readRequest(): String {
        input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        output = PrintWriter(clientSocket.getOutputStream())

        var line: String
        var request = ""

        while (input.readLine().also { line = it } != null) {
            if (line.isEmpty()) break
            request += "$line\n"
        }

        return request
    }


    private fun close(): Boolean {
        input.close()
        output.close()
        clientSocket.close()

        return true
    }
}