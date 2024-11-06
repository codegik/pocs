package com.codegik.opentelemetry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpentelemetryApplication

fun main(args: Array<String>) {
	runApplication<OpentelemetryApplication>(*args)
}
