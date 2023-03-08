package com.codegik.poc.restserver.server

import java.io.BufferedReader
import java.io.InputStreamReader
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
            output = PrintWriter(clientSocket.getOutputStream(), true)
            input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
            val greeting = input.readLine()
            println("Server received $greeting")
        }
    }


    fun addListener(path: String, listener: Any) {

    }

    fun stop() {
        input.close()
        output.close()
        clientSocket.close()
        serverSocket.close()
    }
}