package com.codegik.poc.restserver

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.RestApi

@RestApi
class HelloRestApi {

    @Get("/hello")
    fun hello(): String {
        return "hello world"
    }
}