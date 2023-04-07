package com.microservice.estoquepreco.connections

import org.springframework.stereotype.Component
import org.springframework.amqp.core.Queue

@Component
class RabbitMQConnection {

    fun queue(name: String) = Queue(name, true, true, true)
}