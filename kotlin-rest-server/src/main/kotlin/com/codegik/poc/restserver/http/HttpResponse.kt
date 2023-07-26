package com.codegik.poc.restserver.http

data class HttpResponse(
    val headers: Map<String, String>,
    val status: String,
    val body: String)