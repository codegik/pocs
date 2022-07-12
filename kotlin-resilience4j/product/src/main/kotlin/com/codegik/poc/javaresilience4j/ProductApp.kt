package com.codegik.poc.javaresilience4j

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProductApp

fun main(args: Array<String>) {
    runApplication<ProductApp>(*args);
}