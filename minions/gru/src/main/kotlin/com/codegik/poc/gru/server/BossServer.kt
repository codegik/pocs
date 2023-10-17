package com.codegik.poc.gru.server

import java.net.ServerSocket
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors


class BossServer(
    port: Int = 6666,
    numThreads: Int = 100
) {
    private var isAcceptingRequests = true
    private val serverSocket = ServerSocket(port)
    private val workerPool = Executors.newFixedThreadPool(numThreads)
    private val minionConnections = ConcurrentHashMap<String, MinionConnection>()


    fun start() {
        workerPool.submit {
            println("[Gru] Listening on port ${serverSocket.localPort}")
            while (isAcceptingRequests) {
                val clientSocket = serverSocket.accept()
                val id = "${UUID.randomUUID().toString()}"
                minionConnections[id] = MinionConnection(clientSocket, id, this)
                workerPool.submit {
                    minionConnections[id]?.startListening()
                }
            }
            println("[Gru] Stop listening")
        }
    }


    fun stop() {
        serverSocket.close()
        isAcceptingRequests = false
    }


    fun disconnectMinion(minionId: String) =
        minionConnections.remove(minionId)
}