package com.codegik.poc.restserver.handler

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import java.lang.reflect.Method


class GetRequestHandler(private val instance: Any, private val method: Method) : HttpHandler {

    override fun handle(exchange: HttpExchange?) {
        val outputStream = exchange?.responseBody
        val result = method.invoke(instance)
        exchange?.sendResponseHeaders(200, result.toString().length.toLong());
        outputStream?.write(result.toString().toByteArray())
        outputStream?.flush()
        outputStream?.close()
    }

}