package com.codegik.poc.github

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class App : CommandLineRunner {
    override fun run(vararg args: String?) {

    }
}

fun main(args: Array<String>) {
    runApplication<App>(*args);
}
