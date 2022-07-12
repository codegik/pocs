package com.codegik.poc.javaresilience4j

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShopApp

fun main(args: Array<String>) {
    runApplication<ShopApp>(*args);
}