package com.codegik.poc.codegen.definition

data class YmlDefinition(
    val app: App
)

data class App(
    val packageName: String = "com.generated",
    val domains: List<Domain> = listOf(),
    val controllers: List<Controller> = listOf()
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
