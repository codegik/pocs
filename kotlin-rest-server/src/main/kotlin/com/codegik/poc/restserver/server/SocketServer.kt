package com.codegik.poc.restserver.server

import java.net.ServerSocket
import kotlin.concurrent.thread


class SocketServer(port: Int = 6666) {
    private var isAcceptingRequests = true
    private val serverSocket: ServerSocket = ServerSocket(port)

    fun start() {
        println("Server start listening")
        while (isAcceptingRequests) {
            val clientSocket = serverSocket.accept()
            thread {
                RequestDispatcher(clientSocket).process()
            }
        }
        println("Server stop listening")
    }


    fun addListener(path: String, listener: Any) {

    }

    fun stop() {
        serverSocket.close()
        isAcceptingRequests = false
    }
}