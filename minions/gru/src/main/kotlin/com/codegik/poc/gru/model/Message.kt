package com.codegik.poc.gru.model

data class Message(
    val action: Action,
    val content: List<String> = listOf()
)