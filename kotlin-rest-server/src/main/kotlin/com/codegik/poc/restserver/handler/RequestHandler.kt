package com.codegik.poc.restserver.handler

import com.codegik.poc.restserver.model.HttpRequest
import com.codegik.poc.restserver.model.HttpResponse

interface RequestHandler {

    fun httpRequest(httpRequest: HttpRequest): RequestHandler

    fun handle(): HttpResponse

}