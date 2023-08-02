package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.model.HttpHeader.CONTENT_TYPE
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_OK

@RestApi
class HelloRestApi {

    @Get("/hello")
    fun getHello(): HttpResponse {
        val headers = mutableMapOf(CONTENT_TYPE to "text/plain;charset=utf-8")
        return HttpResponse(headers = headers, status = HTTP_OK, body = "hello world!")
    }

    @Post("/hello")
    fun saveHello(): HttpResponse {
        val headers = mutableMapOf(CONTENT_TYPE to "text/plain;charset=utf-8")
        return HttpResponse(headers = headers, status = HTTP_OK, body = "hello world!")
    }

    @Get("/not-return-http-response")
    fun getNotReturnHttpResponse(): String {
        return "Hello world!"
    }

    fun notAnnotatedWithApiMethod(): HttpResponse {
        val headers = mutableMapOf(CONTENT_TYPE to "text/plain;charset=utf-8")
        return HttpResponse(headers = headers, status = HTTP_OK, body = "hello world!")
    }
}