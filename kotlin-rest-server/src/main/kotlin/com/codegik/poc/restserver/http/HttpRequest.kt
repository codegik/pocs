package com.codegik.poc.restserver.http

data class HttpRequest(
    val headers: Map<String, String>,
    val endpoint: String,
    val method: HttpMethod,
    val body: String)