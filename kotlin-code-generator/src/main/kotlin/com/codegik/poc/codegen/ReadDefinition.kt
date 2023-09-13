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

}