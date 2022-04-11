package com.dhgb.sockets.socketclient.controller

import com.dhgb.sockets.socketclient.sockets.MyStompSessionHandler
import org.springframework.http.HttpStatus
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.client.WebSocketClient
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient


//Client
@RestController
class Controller {

    private val transport: WebSocketClient = StandardWebSocketClient()
    private val stompClient: WebSocketStompClient = WebSocketStompClient(transport)
    private val sessionHandler: StompSessionHandler = MyStompSessionHandler()
    private val stompSession: StompSession = stompClient.connect(URL, sessionHandler).get()

    init {
//        stompClient.messageConverter = MappingJackson2MessageConverter()
        stompSession.subscribe(SUBSCRIBE, sessionHandler)
    }

    @PostMapping("/info")
    fun test(@RequestBody data: String): HttpStatus {
        println("Se va a enviar $data")
        return try {
            stompSession.send(DESTINATION, passTextToArrayByteArray(data))
            HttpStatus.OK
        }catch (e: Exception){
            HttpStatus.CONFLICT
        }
    }

    fun passTextToArrayByteArray(text: String) : ByteArray{
        return text.encodeToByteArray()
    }

    companion object{
        const val URL = "ws://localhost:8080/current"
        const val DESTINATION = "/server/current"
        const val SUBSCRIBE = "/client/messages"
    }
}