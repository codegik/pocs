package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.annotation.Delete
import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_OK

@RestApi
class HelloRestApi {

    @Get("/hello/")
    fun getHello(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello world!")
    }

    @Get("/hello/{name}")
    fun getHelloName(name: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello $name!")
    }

    @Post("/hello")
    fun saveHelloWithoutRequestPayload(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello world!")
    }

    @Delete("/hello")
    fun delete(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello delete!")
    }

    @Post("/hello-with-body")
    fun saveHelloWithRequestPayload(requestPayload: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = requestPayload)
    }

    @Get("/not-return-http-response")
    fun getNotReturnHttpResponse(): String {
        return "Hello world!"
    }

    fun notAnnotatedWithApiMethod(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello world!")
    }
}