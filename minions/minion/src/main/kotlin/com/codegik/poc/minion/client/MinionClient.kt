package com.codegik.poc.minion.client

import com.codegik.poc.minion.model.Command.SEPARATOR
import com.codegik.poc.minion.model.Command.TEST
import com.codegik.poc.minion.model.Response
import com.codegik.poc.minion.model.Status
import com.codegik.poc.minion.model.StressTestConfig
import com.codegik.poc.minion.rest.RestClient
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.lang.Thread.sleep
import java.net.Socket
import java.util.concurrent.Executors


class MinionClient(
    private val host: String = "localhost",
    private val port: Int = 6666
) {
    private var clientSocket: Socket? = null
    private var output: PrintWriter? = null
    private var input: BufferedReader? = null
    private val workerPool = Executors.newFixedThreadPool(10)
    private val gson = Gson()


    fun start() {
        workerPool.submit {
            startListening()
        }
    }


    private fun startListening(): Boolean {
        try {
            connect()
            while (!clientSocket?.isClosed!!) {
                val success = readMessageAsString { strMessage ->
                    println("[Minion] Gru told me to to this: $strMessage")
                    processRequest(strMessage) { response ->
                        writeResponse(response)
                    }
                }

                if (!success) {
                    println("[Minion] Gru kicked me")
                    close()
                    connect()
                }
            }

            return false
        } catch (e: Exception) {
            println("[Minion] Gru kicked me")
            e.printStackTrace()
            close()

            return false
        }
    }


    private fun close(): Boolean {
        input?.close()
        output?.close()
        clientSocket?.close()

        return true
    }


    private fun readMessageAsString(process: (String) -> Boolean): Boolean {
        val message = input?.readLine()

        if (message != null && message.trim().isNotEmpty()) {
            return process(message)
        }

        return false
    }


    private fun processRequest(message: String, process: (Response) -> Boolean): Boolean {
        try {
            val (command, json) = message.split(SEPARATOR)
            val data = gson.fromJson(json, StressTestConfig::class.java)

            when (command) {
                TEST -> return RestClient(data).start()
            }

            return process(Response(status = Status.OK))
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }


    private fun writeResponse(response: Response): Boolean {
        output?.println(gson.toJson(response))

        return true
    }


    private fun connect(): Boolean {
        while (true) {
            try {
                if (clientSocket == null || clientSocket!!.isClosed) {
                    clientSocket = Socket(host, port)
                    output = PrintWriter(clientSocket!!.getOutputStream(), true)
                    input = BufferedReader(InputStreamReader(clientSocket!!.inputStream))
                    println("[Minion] I'm in the party")
                    return true
                }
            } catch (e: Exception) {
                println("[Minion] Trying to join the party")
                sleep(5000)
            }
        }

        return false
    }
}