package com.codegik.poc.codegen.generator

import java.io.File

class SourceCodeWriter(private val directory: File = File(".")) {

    fun write(sourceCode: SourceCode): File {
        val file = File(directory, sourceCode.fileName)
        file.writeText(sourceCode.fileContent)
        return file
    }
}