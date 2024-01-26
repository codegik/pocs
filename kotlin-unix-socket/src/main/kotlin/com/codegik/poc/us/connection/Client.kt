package com.codegik.poc.us.connection

import java.net.StandardProtocolFamily
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel


class Client {
    private val config = Config()
    private val channel = SocketChannel.open(StandardProtocolFamily.UNIX)

    fun connect() {
        channel.connect(config.socketAddress())
    }

    fun send(text: String) {
        val buffer = byteBuffer(text)

        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        println("[Client] Message sent")
    }

    private fun byteBuffer(text: String): ByteBuffer {
        val buffer: ByteBuffer = ByteBuffer.allocate(1024)

        buffer.clear()
        buffer.put(text.toByteArray())
        buffer.flip()

        return buffer
    }
}