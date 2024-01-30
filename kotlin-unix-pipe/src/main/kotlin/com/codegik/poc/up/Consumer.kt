package com.codegik.poc.up

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        println("receiving => $line")
    }

}