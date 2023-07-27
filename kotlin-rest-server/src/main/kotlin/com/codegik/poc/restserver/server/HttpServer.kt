package com.codegik.poc.restserver.server

import java.net.ServerSocket
import java.util.concurrent.Executors


class HttpServer(
    port: Int = 6666,
    numThreads: Int = 100
) {
    private var isAcceptingRequests = true
    private val serverSocket: ServerSocket = ServerSocket(port)
    private val workerPool = Executors.newFixedThreadPool(numThreads)

    fun start() {
        workerPool.submit {
            println("Server start listening")
            while (isAcceptingRequests) {
                val clientSocket = serverSocket.accept()
                workerPool.submit { RequestDispatcher(clientSocket).process() }
            }
            println("Server stop listening")
        }
    }


    fun stop() {
        serverSocket.close()
        isAcceptingRequests = false
    }
}