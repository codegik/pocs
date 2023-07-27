package com.codegik.poc.restserver

import com.codegik.poc.restserver.server.HttpServer
import org.junit.jupiter.api.Test


class HttpServerTest {

    private val server = HttpServer()


    @Test
    fun test() {
        server.start()

        // TODO: use a rest client to call http server
    }
}