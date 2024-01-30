package com.codegik.poc.up

import java.lang.Thread.sleep
import java.util.stream.Stream


fun main(args: Array<String>) {
    Stream.generate { System.nanoTime() }
        .map { it.toString() }
        .forEach {
            println(it)
            sleep(1000)
        }
}