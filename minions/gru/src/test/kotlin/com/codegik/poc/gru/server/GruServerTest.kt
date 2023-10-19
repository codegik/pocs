package com.codegik.poc.gru.server

import com.codegik.poc.gru.model.StressTestConfig
import com.google.gson.Gson
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GruServerTest {
	private val host = "localhost"
	private val port = 9999
	private val gruServer = GruServer(9999)


	@BeforeAll
	fun before() {
		gruServer.start()
	}


	@AfterAll
	fun after() {
		gruServer.stop()
	}


	@Test
	fun shouldSuccessWhenRequestEndpoint() {
		val client = Socket(host, port)
		val output = PrintWriter(client.getOutputStream(), true)
		val input = BufferedReader(InputStreamReader(client.inputStream))
		val json = Gson().toJson(StressTestConfig("https://google.com", 10))

		println("[Minion] sending: $json")
		output.println(json)
		println("[Minion] receiving: ${input.readLine()}")
		client.close()
		println("[Minion] disconnected")
	}

}
