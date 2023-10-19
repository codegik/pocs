package com.codegik.poc.gru.server

import com.codegik.poc.gru.model.Command.TEST
import com.codegik.poc.gru.model.CommandMessage
import com.codegik.poc.gru.model.StressTestConfig
import java.net.ServerSocket
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import kotlin.concurrent.thread


class GruServer(
    port: Int = 6666,
    numThreads: Int = 100
) {
    private var isAcceptingRequests = true
    private val serverSocket = ServerSocket(port)
    private val workerPool = Executors.newFixedThreadPool(numThreads)
    private val minionConnections = ConcurrentHashMap<String, MinionConnection>()


    fun start() {
        workerPool.submit {
            println("[Gru] Listening minions on port ${serverSocket.localPort}")
            while (isAcceptingRequests) {
                val clientSocket = serverSocket.accept()
                val id = "${clientSocket.inetAddress.hostAddress} ${clientSocket.inetAddress.canonicalHostName} ${clientSocket.port}"
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

    fun triggerTest(message: CommandMessage) {
        thread {
            minionConnections.map {
                it.value.write(message)
            }
        }
    }
}