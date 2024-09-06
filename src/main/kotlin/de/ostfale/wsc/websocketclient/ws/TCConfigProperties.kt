package de.ostfale.wsc.websocketclient.ws

import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "websocket")
class TCConfigProperties {
    private val log = LoggerFactory.getLogger(javaClass)

    lateinit var baseProtocol: String
    lateinit var baseURL: String
    lateinit var basePort: String
    lateinit var wsPath: String
    lateinit var allowedOrigins: String

    fun getWebSocketPath(): String {
        val path = "$baseProtocol://$baseURL:$basePort$wsPath"
        log.info("WEBSOCKET Path: $path")
        return path
    }
}
