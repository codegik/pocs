package com.codegik.poc.config

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.socket.*
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import java.net.InetAddress
import java.util.concurrent.CopyOnWriteArrayList


@Configuration
@EnableWebSocket
class WebSocketConfig(
    private val webSocketHandler: WebSocketHandler
) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(webSocketHandler, "/real-time-message")
    }

}


@Component
class WebSocketHandler : org.springframework.web.socket.WebSocketHandler {
    private val logger = LoggerFactory.getLogger(WebSocketHandler::class.java)
    private val activeSessions = CopyOnWriteArrayList<WebSocketSession>()

    @Throws(Exception::class)
    override fun afterConnectionEstablished(session: WebSocketSession) {
        activeSessions.add(session)
        val ip = InetAddress.getLocalHost()
        logger.info("New client ${session.id} connected")
    }

    @Throws(Exception::class)
    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        val textMessage = message.payload.toString()

        logger.info("Receive message from client ${session.remoteAddress}: $textMessage")

        for (activeSession in activeSessions) {
            if (activeSession.isOpen && activeSession.id != session.id) {
                activeSession.sendMessage(TextMessage(textMessage))
            }
        }
    }

    @Throws(Exception::class)
    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        logger.info("Client ${session.id} disconnected")
    }

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        activeSessions.remove(session)
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }

    fun broadcastMessage(message: String) {
        logger.info("Server broadcasting message")
        for (activeSession in activeSessions) {
            if (activeSession.isOpen) {
                activeSession.sendMessage(TextMessage(message))
            }
        }
    }
}