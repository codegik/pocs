package com.codegik.poc.codegen.generator

import com.codegik.poc.codegen.definition.YmlDefinition

class ClassGenerator(private val definition: YmlDefinition) {

    fun buildEntity(): List<SourceCode> {
        return definition.app.domains.map { domain ->
            val fields = domain.fields.joinToString(", ") {
                field -> "val ${field.name}: ${field.type}"
            }
            val content =
                """package ${definition.app.packageName}
                |
                |data class ${domain.name} ($fields)""".trimMargin()
            SourceCode("${domain.name}.kt", content)
        }.toList()
    }


    fun buildRepository(): List<SourceCode> {
        return definition.app.domains.map { domain ->
            val keyField = domain.fields.first { it.isKey }
            val content =
                """package ${definition.app.packageName}
                |
                |interface ${domain.name}Repository : CrudRepository<${domain.name}, ${keyField.type}> {
                |   fun findBy${keyField.name.replaceFirstChar { it.uppercase() }}(${keyField.name}: ${keyField.type}): ${domain.name}?
                |}""".trimMargin()
            SourceCode("${domain.name}Repository.kt", content)
        }.toList()
    }


    fun buildService(): List<SourceCode> {
        return definition.app.domains.map { domain ->
            val keyField = domain.fields.first { it.isKey }
            val content =
                """package ${definition.app.packageName}
                |
                |class ${domain.name}Service(private val repository: ${domain.name}Repository> {
                |   fun findBy${keyField.name.replaceFirstChar { it.uppercase() }}(${keyField.name}: ${keyField.type}): ${domain.name}? {
                |       return repository.findBy${keyField.name.replaceFirstChar { it.uppercase() }}(${keyField.name})
                |   }
                |   fun findAll(): List<${domain.name}> {
                |       return repository.findAll()
                |   }
                |   fun save(${domain.name.lowercase()}: ${domain.name}): ${domain.name} {
                |       return repository.save(${domain.name.lowercase()})
                |   }
                |}""".trimMargin()
            SourceCode("${domain.name}Service.kt", content)
        }.toList()
    }
}