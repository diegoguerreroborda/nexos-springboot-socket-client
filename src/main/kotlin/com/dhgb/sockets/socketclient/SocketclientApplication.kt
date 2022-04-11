package com.dhgb.sockets.socketclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class SocketclientApplication

fun main(args: Array<String>) {
	runApplication<SocketclientApplication>(*args)
}
