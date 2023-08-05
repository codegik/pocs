package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.model.HttpMethod.GET
import com.codegik.poc.restserver.model.HttpMethod.POST
import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import java.lang.reflect.Method


class HttpRequestHandler(private val instance: Any, private val method: Method) {

    fun handle(httpRequest: HttpRequest): HttpResponse {
        val result = when (httpRequest.method) {
            GET -> method.invoke(instance)
            POST -> {
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