package com.codegik.poc.minion.model

data class Message(
    val action: Action,
    val content: List<String> = listOf()
)