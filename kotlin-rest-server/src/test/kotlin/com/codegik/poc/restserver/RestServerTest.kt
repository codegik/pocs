package com.codegik.poc.restserver

import com.codegik.poc.restserver.annotation.Get
import com.codegik.poc.restserver.annotation.RestApi
import com.codegik.poc.restserver.handler.GetRequestHandler
import com.codegik.poc.restserver.server.RestServer
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RestServerTest {

	private val server = RestServer()


	@Test
	fun loadClasses() {
		val classes = server.loadRestApiClasses();
		assertTrue { classes.contains(HelloRestApi::class.java) }
		assertFalse { classes.contains(RestApi::class.java) }
		assertFalse { classes.contains(Get::class.java) }
		assertFalse { classes.contains(GetRequestHandler::class.java) }
	}


	@Test
	fun startServer() {
		val result = server.start()
		assertEquals(1, result.size)
	}
}
