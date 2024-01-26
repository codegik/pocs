package com.codegik.poc.us.connection

import java.net.UnixDomainSocketAddress
import java.nio.file.Path

class Config {
    private val socketPath = Path.of("/tmp").resolve("poc.socket")

    fun socketPath(): Path {
        return socketPath
    }

    fun socketAddress(): UnixDomainSocketAddress {
        return UnixDomainSocketAddress.of(socketPath)!!
    }
}