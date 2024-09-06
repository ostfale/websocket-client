package de.ostfale.wsc.websocketclient.api

import de.ostfale.wsc.websocketclient.service.ClientWSTriggerService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/action")
class ClientController(
    private val clientWSTriggerService: ClientWSTriggerService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/connect")
    fun connect() {
        log.info("CONTROLLER :: Connect to WebSocket service")
        clientWSTriggerService.connect()
    }
}
