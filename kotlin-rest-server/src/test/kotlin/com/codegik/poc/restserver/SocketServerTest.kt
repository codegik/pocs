package com.codegik.poc.restserver

import com.codegik.poc.restserver.server.SocketServer
import org.junit.jupiter.api.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket




class SocketServerTest {

    private val server = SocketServer()


    @Test
    fun test() {
        server.start()

        val clientSocket = Socket("127.0.0.1", 6666)
        val out = PrintWriter(clientSocket.getOutputStream(), true)
        val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
        out.println("hey dude")
        val resp = input.readLine()
        println("response: $resp")

        server.stop()
    }
}