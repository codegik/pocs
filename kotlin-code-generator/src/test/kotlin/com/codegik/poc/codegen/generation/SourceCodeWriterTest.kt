package com.codegik.poc.codegen.generation

import com.codegik.poc.codegen.definition.ReadDefinition
import com.codegik.poc.codegen.generator.ClassGenerator
import com.codegik.poc.codegen.generator.SourceCodeWriter
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SourceCodeWriterTest {
    private val yml = ReadDefinition().fromYml("src/test/resources/sample-app.yml")
    private val classGenerator = ClassGenerator(yml!!)
    private val sourceCodeWriter = SourceCodeWriter(File("/tmp"))

    @BeforeAll
    fun setup() {
        File("/tmp").walk()
            .filter { it.name.endsWith(".kt") }
            .map { it.delete() }
            .count()
    }

    @Test
    fun shouldSuccessWhenWriteEntity() {
        val sourceCodes = classGenerator.buildEntity().map { sourceCodeWriter.write(it) }

        assertTrue(sourceCodes[0].exists())
        assertTrue(sourceCodes[1].exists())
    }
}