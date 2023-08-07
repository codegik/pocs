package com.codegik.poc.restserver.model

import com.codegik.poc.restserver.model.HttpHeader.CONTENT_TYPE

data class HttpResponse(
    val headers: MutableMap<String, String> = mutableMapOf(CONTENT_TYPE to "text/plain;charset=utf-8"),
    val status: String,
    val body: String
)