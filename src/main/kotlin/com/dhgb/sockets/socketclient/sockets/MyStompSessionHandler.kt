package com.dhgb.sockets.socketclient.sockets

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import java.lang.reflect.Type

@Configuration
@EnableWebSocket
class MyStompSessionHandler: StompSessionHandler {
    override fun getPayloadType(headers: StompHeaders): Type {
        TODO("Not yet implemented")
    }

    override fun handleFrame(headers: StompHeaders, payload: Any?) {
        println("handleframe")
        val message: String = payload.toString()
        println("handeFrame es $message")
    }

    override fun afterConnected(session: StompSession, connectedHeaders: StompHeaders) {
        println("session es ${session.isConnected}")
        println("ccHeaders es $connectedHeaders")
        val la = "esto va"
//        val message = Message("holas", "Diego")
        val message2 = la.encodeToByteArray()
//        session.send("/app/chat", passTextToArrayByteArray("Lo que sea"))
//        session.subscribe("/topic/messages", this)
    }

    override fun handleException(session: StompSession, command: StompCommand?, headers: StompHeaders, payload: ByteArray, exception: Throwable) {
        println("Handle Exception: $exception")
    }

    override fun handleTransportError(session: StompSession, exception: Throwable) {
        println("transport ERROR")
    }

}