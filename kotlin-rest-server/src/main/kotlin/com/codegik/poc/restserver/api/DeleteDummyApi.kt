package com.codegik.poc.restserver.api

import com.codegik.poc.restserver.annotation.Delete
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_OK

@RestApi
class DeleteDummyApi {

    @Delete("/hello")
    fun delete(): HttpResponse {
        return HttpResponse(status = HTTP_OK, body = "hello delete!")
    }

}