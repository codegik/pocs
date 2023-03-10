package com.codegik.poc.restserver

import com.codegik.poc.restserver.server.SocketServer
import org.junit.jupiter.api.Test
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket


class SocketServerTest {

    private val server = SocketServer()


    @Test
    fun test() {
        server.start()

        val clientSocket = Socket("127.0.0.1", 6666)
        val output = ObjectOutputStream(clientSocket.getOutputStream())
        val input = ObjectInputStream(clientSocket.getInputStream());

        output.writeObject("hey dude");

        val resp = input.readObject()

        println("Client received: $resp")
        input.close()
        output.close()

        server.stop()
    }
}