package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.model.HttpMethod.DELETE
import com.codegik.poc.restserver.model.HttpMethod.GET
import com.codegik.poc.restserver.model.HttpMethod.POST
import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import java.lang.reflect.Method


class HttpRequestHandler(private val instance: Any, private val method: Method) {

    fun handle(httpRequest: HttpRequest): HttpResponse {
        /**
         * todo:
         * - httpRequest should have number of pathParameters
         * - httpRequest should have pathParameters mapped to use as parameter in invoke
         */
        val result = when (httpRequest.method) {
            GET -> method.invoke(instance, httpRequest.pathParameters)
            POST, DELETE -> {
                if (method.parameters.size == 1) {
                    method.invoke(instance, httpRequest.body)
                } else {
                    method.invoke(instance)
                }
            }
        }

        if (result is HttpResponse) {
            return result
        }

        throw RuntimeException("${instance.javaClass.simpleName}.${method.name} is not returning a HttpResponse type")
    }

}