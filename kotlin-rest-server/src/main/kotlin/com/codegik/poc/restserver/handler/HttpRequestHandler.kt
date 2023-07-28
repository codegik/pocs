package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import java.lang.reflect.Method


class HttpRequestHandler(private val instance: Any, private val method: Method) {

    fun handle(httpRequest: HttpRequest): HttpResponse {
        val result = method.invoke(instance)

        if (result is HttpResponse) {
            return method.invoke(instance) as HttpResponse
        }

        throw RuntimeException("${instance.javaClass.simpleName}.${method.name} is not returning a HttpResponse type")
    }

}