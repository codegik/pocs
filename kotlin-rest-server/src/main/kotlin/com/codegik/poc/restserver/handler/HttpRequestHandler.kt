package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.model.HttpMethod.POST
import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_BAD_REQUEST
import java.lang.reflect.Method


/**
 * TODO
 * - add urlencode/decode support for request parameters
 */
class HttpRequestHandler(private val instance: Any, private val method: Method) {

    fun handle(httpRequest: HttpRequest): HttpResponse {
        val parameters = arrayListOf<Any>()

        if (httpRequest.method == POST) {
            if (httpRequest.body.isNotEmpty()) {
                parameters.add(httpRequest.body)
            }
        }

        if (httpRequest.pathParameters.isNotEmpty()) {
            parameters.addAll(httpRequest.pathParameters)
        }

        if (parameters.size == method.parameters.size) {
            val result = method.invoke(instance, *parameters.toArray())

            if (result is HttpResponse) {
                return result
            }

            throw RuntimeException("${instance.javaClass.simpleName}.${method.name} is not returning a HttpResponse type")
        }

        println("${instance.javaClass.simpleName}.${method.name} " +
                "is expecting arguments ${method.parameters.map { it.annotatedType }}, " +
                "but its receiving ${parameters.map { it.javaClass }}")

        return HttpResponse(status = HTTP_BAD_REQUEST, body = "number of parameters doesn't match with number of arguments")
    }

}