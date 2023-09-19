package com.codegik.poc.codegen

class ClassGenerator(private val definition: YmlDefinition) {

    fun buildEntity(): List<String> {
        return definition.app.domains.map { domain ->
            val fields = domain.fields.joinToString(", ") {
                field -> "val ${field.name}: ${field.type}"
            }
            "data class ${domain.name} ($fields)"
        }.toList()
    }


    fun buildRepository(): List<String> {
        return definition.app.domains.map { domain ->
            val keyField = domain.fields.first { it.isKey }
            val fields = domain.fields.joinToString(", ") {
                field -> "val ${field.name}: ${field.type}"
            }
            """interface ${domain.name}Repository : CrudRepository<${domain.name}, ${keyField.type}> {
                |   fun findBy${keyField.name.replaceFirstChar { it.uppercase() }}(${keyField.name}: ${keyField.type}): ${domain.name}?
                |}""".trimMargin()
        }.toList()
    }
}