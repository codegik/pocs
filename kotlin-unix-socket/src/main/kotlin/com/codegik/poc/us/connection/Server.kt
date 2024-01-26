package com.codegik.poc.us.connection

import java.io.IOException
import java.net.StandardProtocolFamily
import java.nio.ByteBuffer
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel
import java.nio.file.Files
import java.util.*


class Server {
    private val config = Config()

    fun listening() {
        Files.deleteIfExists(config.socketPath());

        val serverChannel = ServerSocketChannel.open(StandardProtocolFamily.UNIX)
        serverChannel.bind(config.socketAddress());
        val channel = serverChannel.accept()

        readSocketMessage(channel).ifPresent {
            message -> println("[Client message] $message")
        }

        Files.deleteIfExists(config.socketPath());
    }

    @Throws(IOException::class)
    private fun readSocketMessage(channel: SocketChannel): Optional<String> {
        val buffer: ByteBuffer = ByteBuffer.allocate(1024)
        val bytesRead: Int = channel.read(buffer)
        if (bytesRead < 0) return Optional.empty()
        val bytes = ByteArray(bytesRead)
        buffer.flip()
        buffer.get(bytes)

        return Optional.of(String(bytes))
    }
}