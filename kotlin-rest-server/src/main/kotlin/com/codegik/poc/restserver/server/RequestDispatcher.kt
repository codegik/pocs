package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.model.HttpHeader.CONNECTION
import com.codegik.poc.restserver.model.HttpHeader.CONTENT_LENGTH
import com.codegik.poc.restserver.model.HttpHeader.HTTP_VERSION
import com.codegik.poc.restserver.model.HttpMethod
import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_INTERNAL_SERVER_ERROR
import com.codegik.poc.restserver.model.HttpStatus.HTTP_NOT_FOUND
import com.codegik.poc.restserver.model.HttpStatus.HTTP_VERSION_NOT_SUPPORTED
import com.codegik.poc.restserver.server.EndpointMapper.mappedEndpoints
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Thread.sleep
import java.net.Socket

class RequestDispatcher(private val clientSocket: Socket) {
    private lateinit var input: BufferedReader
    private lateinit var output: PrintWriter


    fun process(): Boolean {
        val httpRequest: HttpRequest
        val strRequest = readRequestAsString()

        println("Received request")
        println(strRequest)

        try {
            httpRequest = parseRequest(strRequest)
        } catch (e: Exception) {
            val message = "Invalid http request protocol"

            println(message)
            writeResponse(HttpResponse(status = HTTP_VERSION_NOT_SUPPORTED, body = message))
            close()

            return false
        }

        writeResponse(processRequest(httpRequest))

        return close()
    }


    private fun processRequest(httpRequest: HttpRequest): HttpResponse {
        return try {
            val key = Pair("${httpRequest.method}", "${httpRequest.endpoint}")
            if (mappedEndpoints.containsKey(key)) {
                return mappedEndpoints[key]?.handle(httpRequest)!!
            } else {
                val requestPaths = httpRequest.endpoint.split("/")
                mappedEndpoints.keys.forEach {
                    val endpointPaths = it.second.split("/")
                    if (requestPaths.size == endpointPaths.size) {
                        endpointPaths.forEachIndexed { index, path ->
                            // TODO: continue validating the matching path
                            // possible use stack to reduce the values
                            // for each * path founded should add into array of parameters, this array will be passed to the method
                            if (requestPaths[index] == path) {

                            }
                        }
                    }
                }
            }

            return HttpResponse(status = HTTP_NOT_FOUND, body = "Not found")
        } catch (e: Exception) {
            println(e.message)
            return HttpResponse(status = HTTP_INTERNAL_SERVER_ERROR, body = "internal server error")
        }
    }


    @Throws(Exception::class)
    private fun parseRequest(requestText: String): HttpRequest {
        val lines = requestText.split("\n")
        val (method, endpoint, version) = lines[0].split(" ")
        val headers = mutableMapOf<String, String>()
        var isBodyContent = false
        var body = ""

        for (line in lines.subList(1, lines.size)) {
            if (line.isEmpty()) {
                isBodyContent = true
                continue
            }
            if (isBodyContent) {
                body += line + "\n"
            } else {
                val (key, value) = line.split(":")
                headers[key.trim()] = value.trim()
            }
        }

        return HttpRequest(headers = headers, endpoint = endpoint, method = HttpMethod.valueOf(method), body = body.trim())
    }


    private fun writeResponse(httpResponse: HttpResponse): Boolean {
        output = PrintWriter(clientSocket.getOutputStream())
        output.println("$HTTP_VERSION ${httpResponse.status}")

        httpResponse.headers[CONTENT_LENGTH] = httpResponse.body.length.toString()
        httpResponse.headers[CONNECTION] = "close"
        httpResponse.headers.forEach { output.println("${it.key.trim()}: ${it.value.trim()}") }

        output.println("")
        output.print(httpResponse.body);
        output.flush() // move to the caller

        return true
    }


    private fun readRequestAsString(): String {
        input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))

        var line: String
        var request = ""

        while (input.readLine().also { line = it } != null) {
            if (line.isEmpty())
                break
            request += "$line\n"
        }

        request += "\n"
        /**
         * WTF sleep(5): have to write that shi* to make java.net.http.HttpClient works,
         * otherwise it will not read the body in POST requests.
         * The Unit Tests might fail in other machines.
         * Fortunately its working using curl and postman clients without sleep(5).
         */
        sleep(5)
        while (input.ready()) {
            request += input.read().toChar()
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