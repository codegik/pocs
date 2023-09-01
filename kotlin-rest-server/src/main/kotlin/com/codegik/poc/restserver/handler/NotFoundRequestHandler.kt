package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse
import com.codegik.poc.restserver.model.HttpStatus.HTTP_BAD_REQUEST
import com.codegik.poc.restserver.model.HttpStatus.HTTP_NOT_FOUND


class NotFoundRequestHandler: RequestHandler {

    override fun httpRequest(httpRequest: HttpRequest): NotFoundRequestHandler {
        return this
    }


    override fun handle(): HttpResponse {
        return HttpResponse(status = HTTP_NOT_FOUND, body = "Not found")
    }

}