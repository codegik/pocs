package com.codegik.poc.restserver.model

data class HttpResponse(
    val headers: MutableMap<String, String>,
    val status: String,
    val body: String
)