package com.codegik.poc.us

import com.codegik.poc.us.connection.Server

fun main(args: Array<String>) {
    val server = Server()
    println("[Server] Started")
    server.listening()
}