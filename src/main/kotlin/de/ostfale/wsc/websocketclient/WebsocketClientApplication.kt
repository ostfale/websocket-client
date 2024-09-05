package de.ostfale.wsc.websocketclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebsocketClientApplication

fun main(args: Array<String>) {
    runApplication<WebsocketClientApplication>(*args)
}
