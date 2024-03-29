package com.codegik.dontpad.config

import com.codegik.dontpad.service.DontpadService
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.socket.*
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import java.net.InetAddress
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList


@Configuration
@EnableWebSocket
class WebSocketConfig(val dontpadService: DontpadService) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(myHandler(), "/my-websocket-endpoint")
    }

    @Bean
    fun myHandler(): WebSocketHandler {
        return SimpleWebSocketHandler(dontpadService)
    }
}


@Component
class SimpleWebSocketHandler(val dontpadService: DontpadService) : WebSocketHandler {
    private val logger = LoggerFactory.getLogger(SimpleWebSocketHandler::class.java)
    private val activeSessions = CopyOnWriteArrayList<WebSocketSession>()
    private val activeEditors = ConcurrentHashMap<String, String>()
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
        val dontpadValue = rootNode.path("dontpadValue").asText()
        val dontpadName = rootNode.path("dontpadName").asText()

        dontpadService.update(dontpadName, dontpadValue)
        activeEditors.putIfAbsent(session.id, dontpadName)
        val ip = InetAddress.getLocalHost()
        logger.info("Node ${ip.hostAddress} receive message from client ${session.id} ${session.remoteAddress}")

        for (activeSession in activeSessions) {
            if (activeSession.isOpen && activeEditors[activeSession.id] == dontpadName) {
                activeSession.sendMessage(TextMessage(
                    "<textarea cols=\"2\" rows=\"10\" id=\"dontpadValue\" name=\"dontpadValue\" hx-swap-oob=\"true\">$dontpadValue</textarea>"
                ))
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
        activeEditors.remove(session.id)
    }

    override fun supportsPartialMessages(): Boolean {
        return false
    }
}