package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_OK

@RestApi
class GetDummyApi {

    @Get("/hello//")
    fun helloIgnoringExtraSlash(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello world!")
    }

    @Get("/hello/{name}")
    fun helloWithRequestParamName(name: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello $name!")
    }

    @Get("/hello/{name}/my/friend")
    fun helloWithRequestParamNamePlusPath(name: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello $name my friend!")
    }

    @Get("/hello/{name}/{nickname}")
    fun helloWithRequestParamNameAndNickname(name: String, nickname: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello $name $nickname!")
    }

    @Get("/hello/{name}/{nickname}/my/friend")
    fun helloWithRequestParamNameAndNicknamePlusPath(name: String, nickname: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello $name $nickname my friend!")
    }

    @Get("/hello/{name}/{midName}/{lastNme}/my/friend")
    fun helloWithThreeRequestParamWithoutThreeParameters(name: String, nickname: String): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello $name $nickname my friend!")
    }

    @Get("/not-return-http-response")
    fun notReturnHttpResponse(): String {
        return "Hello world!"
    }

    fun notAnnotatedWithApiMethod(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello world!")
    }
}