package com.codegik.poc.minion.model

data class Response(
    val status: Status,
    val content: String = ""
)