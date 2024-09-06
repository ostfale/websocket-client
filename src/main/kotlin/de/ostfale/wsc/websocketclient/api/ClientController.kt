package de.ostfale.wsc.websocketclient.api

import de.ostfale.wsc.websocketclient.service.ClientWSTriggerService
import de.ostfale.wsc.websocketclient.ws.TCWebSocketSession
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/action")
class ClientController(
    private val clientWSTriggerService: ClientWSTriggerService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/connect")
    fun connect() {
        log.info("CONTROLLER :: Connect to WebSocket service")
        clientWSTriggerService.connect()
    }

    @GetMapping("/sessionid")
    fun getClientSession(): ResponseEntity<String?> {
        log.info("GET Request for clientSession")
        val clientSessionId = TCWebSocketSession.getSessionId()
        return ResponseEntity(clientSessionId, HttpStatus.OK)
    }

    @GetMapping("/ping")
    fun receivedPing(): ResponseEntity<String> {
        log.info("GET Request for ping")
        return ResponseEntity("Pong", HttpStatus.OK)
    }
}
