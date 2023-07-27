package com.codegik.poc.restserver.http

data class HttpResponse(
    val headers: MutableMap<String, String>,
    val status: String,
    val body: String
)