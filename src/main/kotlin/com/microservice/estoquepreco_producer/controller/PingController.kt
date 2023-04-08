package com.microservice.estoquepreco_producer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {

    @GetMapping("/ping")
    fun ping(): String {
        return "pong"
    }
}