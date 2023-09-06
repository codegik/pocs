package com.codegik.poc.restserver.model

class Constants {
    companion object {
        val PATH_VARIABLE_PATTERN = """\{[^}]*\}""".toRegex()
        const val PATH_VARIABLE_REPLACEMENT = "([a-zA-Z0-9%]+)"
    }
}