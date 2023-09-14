package com.codegik.poc.codegen

data class YmlDefinition(
    val app: App
)

data class App(
    val name: String,
    val domains: List<Domain>,
    val controllers: List<Controller>
)

data class Domain(
    val name: String,
    val fields: List<Field>
)

data class Field(
    val name: String,
    val type: String,
    val isKey: Boolean
)

data class Controller(
    val domain: String,
    val methods: List<String> = listOf("GET", "POST", "DELETE")
)
