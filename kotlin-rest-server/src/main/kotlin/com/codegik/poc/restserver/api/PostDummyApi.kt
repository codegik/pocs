package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.annotation.Post
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_OK

@RestApi
class PostDummyApi {

    @Post("/hello")
    fun saveHelloWithoutRequestPayload(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello world!")
    }

    @Post("/hello-with-body")
    fun saveHelloWithRequestPayload(requestPayload: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = requestPayload)
    }

}