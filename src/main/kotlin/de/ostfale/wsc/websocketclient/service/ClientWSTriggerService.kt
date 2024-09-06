package de.ostfale.wsc.websocketclient.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.socket.client.WebSocketConnectionManager

@Service
class ClientWSTriggerService(
    private val connectionManager: WebSocketConnectionManager
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun connect() {
        log.info("ActionTriggerService :: Connect to WebSocket service")
        connectionManager.start()
    }
}
