package com.codegik.poc.minion.client

import com.codegik.poc.minion.model.Message
import com.codegik.poc.minion.model.Response
import com.codegik.poc.minion.model.Status
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Thread.sleep
import java.net.Socket
import java.util.concurrent.Executors


class MinionClient(
    private val host: String,
    private val port: Int = 6666
) {
    private var clientSocket = Socket(host, port)
    private var output = PrintWriter(clientSocket.getOutputStream(), true)
    private var input = BufferedReader(InputStreamReader(clientSocket.inputStream))
    private val workerPool = Executors.newFixedThreadPool(10)
    private val gson = Gson()


    fun start() {
        workerPool.submit {
            startListening()
        }
    }


    private fun startListening(): Boolean {
        try {
            while (!clientSocket.isClosed) {
                println("[Minion] Connected")
                val success = readMessageAsString { strMessage ->
                    println("[Minion] received message: $strMessage")
                    processRequest(strMessage) { response ->
                        writeResponse(response)
                    }
                }

                if (!success) {
                    println("[Minion] Gru disconnected me")
                    close()
                    reconnect()
                }
            }

            return false
        } catch (e: Exception) {
            println("[Minion] Gru disconnected me")
            e.printStackTrace()
            close()

            return false
        }
    }


    private fun close(): Boolean {
        input.close()
        output.close()
        clientSocket.close()

        return true
    }


    private fun readMessageAsString(process: (String) -> Boolean): Boolean {
        val message = input.readLine()

        if (message != null && message.trim().isNotEmpty()) {
            return process(message)
        }

        return false
    }


    private fun processRequest(message: String, process: (Response) -> Boolean): Boolean {
        return try {
            val msg = gson.fromJson(message, Message::class.java)
            return process(Response(status = Status.OK))
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }


    private fun writeResponse(response: Response): Boolean {
        output.println(gson.toJson(response))

        return true
    }


    private fun reconnect(): Boolean {
        while (true) {
            try {
                sleep(5000)

                if (clientSocket.isClosed) {
                    clientSocket = Socket(host, port)
                    output = PrintWriter(clientSocket.getOutputStream(), true)
                    input = BufferedReader(InputStreamReader(clientSocket.inputStream))
                    return true
                }
            } catch (e: Exception) {
                println("[Minion] Trying to reconnect")
            }
        }

        return false
    }
}