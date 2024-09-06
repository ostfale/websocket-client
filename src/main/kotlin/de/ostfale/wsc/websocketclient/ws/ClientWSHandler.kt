package de.ostfale.wsc.websocketclient.ws

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

@Component
class ClientWSHandler : TextWebSocketHandler(
) {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        log.info("Received message: {}", message.payload)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        log.info("New connection established -> store session")
        TCWebSocketSession.setSession(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        log.info("Connection closed -> remove session")
        TCWebSocketSession.resetSession()
    }
}

object TCWebSocketSession {
    private val log = LoggerFactory.getLogger(javaClass)

    private var session: WebSocketSession? = null

    fun setSession(webSocketSession: WebSocketSession) {
        log.info("Set client session with ID: {}", webSocketSession.id)
        this.session = webSocketSession
    }

    fun getSession(): WebSocketSession? {
        return this.session
    }

    fun getSessionId(): String? {
        return this.session?.id
    }

    fun resetSession() {
        this.session = null
    }
}
