package com.codegik.poc.codegen

import com.codegik.poc.codegen.MapperConfig.mapper
import kotlin.io.path.Path

class ReadDefinition {

    fun fromYml(fileName: String): YmlDefinition? {
        val file = Path(fileName).toFile()

        return if (file.exists())
            mapper.readValue(file, YmlDefinition::class.java)
        else null
    }

    fun checkConstraints(definition: YmlDefinition): ValidationResult {
        val domainNames = definition.app.domains.map { it.name }

        val violations = definition.app.controllers
            .filter { !domainNames.contains(it.domain) }
            .map { "Controller '${it.domain}' is not in domain list" }
            .toMutableList()

        violations += definition.app.domains
            .filter { domain -> domain.fields.count { it.isKey } == 0 }
            .map { domain -> "Domain '${domain.name}' doesn't have a key field" }

        return ValidationResult(violations)
    }

}

data class ValidationResult(
    val violations: List<String>
) {
    val success: Boolean = violations.isEmpty()
}
