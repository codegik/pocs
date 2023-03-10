package com.codegik.poc.restserver.server

import java.io.BufferedReader
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executors
import kotlin.concurrent.thread


class SocketServer(private val port: Int = 6666) {
    private val serverSocket: ServerSocket = ServerSocket(port)
    private val threadPoolExecutor = Executors.newFixedThreadPool(10)
    private lateinit var input: BufferedReader
    private lateinit var output: PrintWriter
    private lateinit var clientSocket: Socket


    fun start() {
        thread {
            clientSocket = serverSocket.accept()
            val input = ObjectInputStream(clientSocket.getInputStream())
            val output = ObjectOutputStream(clientSocket.getOutputStream())
            val message = input.readObject()

            println("Server received: $message")
            output.writeObject("hey man");

            input.close()
            output.close()
            clientSocket.close()
        }
    }


    fun addListener(path: String, listener: Any) {

    }

    fun stop() {
        serverSocket.close()
    }
}