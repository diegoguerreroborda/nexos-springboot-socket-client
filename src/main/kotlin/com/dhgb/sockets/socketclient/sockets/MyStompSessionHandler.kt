package com.dhgb.sockets.socketclient.sockets

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.web.socket.config.annotation.EnableWebSocket
import java.lang.reflect.Type


@Configuration
@EnableWebSocket
class MyStompSessionHandler: StompSessionHandlerAdapter() {

    override fun getPayloadType(headers: StompHeaders): Type {
        return String::class.java
    }

    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        println("handleframe")
    }

    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        println("session es ${session.isConnected}")
        println("ccHeaders es $connectedHeaders")
    }

    override fun handleException(session: StompSession, command: StompCommand?, headers: StompHeaders, payload: ByteArray, exception: Throwable) {
//        println("handleException: $exception")
        println("payload is ${String(payload)}")
    }

    override fun handleTransportError(session: StompSession, exception: Throwable) {
        println("transport ERROR")
    }

}