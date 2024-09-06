package de.ostfale.wsc.websocketclient.ws

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.client.WebSocketConnectionManager
import org.springframework.web.socket.client.standard.StandardWebSocketClient

@Configuration
class ClientWSConfiguration(
    private val tcConfigProperties: TCConfigProperties
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Bean
    fun connectionManager(): WebSocketConnectionManager {
        log.info("WebSocketConnectionManager created")
        val wsPath = tcConfigProperties.getWebSocketPath() + "CS-SNH-001"
        val manager = WebSocketConnectionManager(client(), webSocketHandler(), wsPath)
        manager.origin = tcConfigProperties.allowedOrigins
        manager.isAutoStartup = false
        return manager
    }

    @Bean
    fun client(): StandardWebSocketClient {
        log.info("StandardWebSocketClient created")
        return StandardWebSocketClient()
    }

    @Bean
    fun webSocketHandler(): ClientWSHandler {
        log.info("ClientWSHandler created")
        return ClientWSHandler()
    }
}
