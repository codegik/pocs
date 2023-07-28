package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.model.HttpHeader.CONTENT_TYPE
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_OK

@RestApi
class HelloRestApi {

    @Get("/hello")
    fun hello(): HttpResponse {
        val headers = mutableMapOf(CONTENT_TYPE to "text/plain;charset=utf-8")
        return HttpResponse(headers = headers, status = HTTP_OK, body = "hello world!")
    }

}