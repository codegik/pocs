package com.codegik.poc.gru.server

import com.codegik.poc.gru.model.Command.SEPARATOR
import com.codegik.poc.gru.model.Command.TEST
import com.codegik.poc.gru.model.CommandMessage
import com.codegik.poc.gru.model.Response
import com.codegik.poc.gru.model.Status.OK
import com.codegik.poc.gru.model.StressTestConfig
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class MinionConnection(
    private val clientSocket: Socket,
    private val id: String,
    private val gruServer: GruServer
) {
    private var input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
    private var output = PrintWriter(clientSocket.getOutputStream(), true)
    private val gson = Gson()


    fun startListening(): Boolean {
        try {
            println("[Gru] Minion $id joined the party")
            while (!clientSocket.isClosed) {
                val success = readMessageAsString { strMessage ->
                    println("[Gru] received message: $strMessage")
                    processRequest(strMessage) { response ->
                        writeResponse(response)
                    }
                }

                if (!success) {
                    println("[Gru] Minion $id left the party")
                    gruServer.disconnectMinion(id)
                    break
                }
            }

            return false
        } catch (e: Exception) {
            println("[Gru] Minion $id left the party")
            e.printStackTrace()
            close()

            return false
        }
    }


    private fun processRequest(message: String, process: (Response) -> Boolean): Boolean {
        try {
            val (command, json) = message.split(SEPARATOR)
            val testConfig = gson.fromJson(json, StressTestConfig::class.java)

            when (command) {
                TEST -> gruServer.triggerTest(CommandMessage(TEST, testConfig))
            }
            return process(Response(status = OK))
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }


    private fun writeResponse(response: Response): Boolean {
        output.println("${response.status}")

        return true
    }


    fun write(command: CommandMessage): Boolean {
        output.println("${command.command}${SEPARATOR}${gson.toJson(command.data)}")

        return true
    }


    private fun readMessageAsString(process: (String) -> Boolean): Boolean {
        val message = input.readLine()

        if (message != null && message.trim().isNotEmpty()) {
            return process(message)
        }

        return false
    }


    private fun close(): Boolean {
        input.close()
        output.close()
        clientSocket.close()

        return true
    }
}