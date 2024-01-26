package com.codegik.poc.us

import com.codegik.poc.us.connection.Client

fun main(args: Array<String>) {
    println("[Client] Started")
    val client = Client()
    client.connect()
    client.send("Hello people, I came by unix sockets")
}