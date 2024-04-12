package com.codegik.poc.config

import com.fasterxml.jackson.databind.ObjectMapper
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
class WebSocketConfig(private val simpleWebSocketHandler: SimpleWebSocketHandler) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(simpleWebSocketHandler, "/my-websocket-endpoint")
    }

}


@Component
class SimpleWebSocketHandler : WebSocketHandler {
    private val logger = LoggerFactory.getLogger(SimpleWebSocketHandler::class.java)
    private val activeSessions = CopyOnWriteArrayList<WebSocketSession>()
    private val objectMapper = ObjectMapper()

    @Throws(Exception::class)
    override fun afterConnectionEstablished(session: WebSocketSession) {
        activeSessions.add(session)
        val ip = InetAddress.getLocalHost()
        logger.info("Node ${ip.hostAddress} receive new client ${session.id}")
    }

    @Throws(Exception::class)
    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        val rootNode = objectMapper.readTree(message.payload.toString())
        val textMessage = rootNode.path("textMessage").asText()
        val ip = InetAddress.getLocalHost()

        logger.info("Node ${ip.hostAddress} receive message from client ${session.id} ${session.remoteAddress}")

        for (activeSession in activeSessions) {
            if (activeSession.isOpen) {
                activeSession.sendMessage(TextMessage(textMessage))
            }
        }
    }

    @Throws(Exception::class)
    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        logger.info("Error: " + exception.message)
    }

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        activeSessions.remove(session)
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}