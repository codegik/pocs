package com.codegik.poc.restserver.server

import java.net.ServerSocket
import kotlin.concurrent.thread


class HttpServer(port: Int = 6666) {
    private var isAcceptingRequests = true
    private val serverSocket: ServerSocket = ServerSocket(port)

    fun start() {
        println("Server start listening")
        while (isAcceptingRequests) {
            val clientSocket = serverSocket.accept()
            // TODO: use thread pool instead create new thread every call
            thread {
                RequestDispatcher(clientSocket).process()
            }
        }
        println("Server stop listening")
    }


    fun stop() {
        serverSocket.close()
        isAcceptingRequests = false
    }
}