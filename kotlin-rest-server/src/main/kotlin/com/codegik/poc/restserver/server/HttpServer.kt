package com.codegik.poc.restserver.server

import com.codegik.poc.restserver.handler.RequestHandlerMapper.registerRequestHandlers
import java.net.ServerSocket
import java.util.concurrent.Executors


class HttpServer(
    port: Int = 6666,
    numThreads: Int = 100
) {
    private var isAcceptingRequests = true
    private val serverSocket = ServerSocket(port)
    private val workerPool = Executors.newFixedThreadPool(numThreads)


    fun start() {
        val handlersMap = registerRequestHandlers()

        workerPool.submit {
            println("Server started on port ${serverSocket.localPort}")
            while (isAcceptingRequests) {
                val clientSocket = serverSocket.accept()
                workerPool.submit {
                    RequestDispatcher(clientSocket, handlersMap).process()
                }
            }
            println("Server stop listening")
        }
    }


    fun stop() {
        serverSocket.close()
        isAcceptingRequests = false
    }
}