package com.microservice.estoquepreco_producer.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitMQService(
    @Autowired
    private val rabbitTemplate: RabbitTemplate
) {

    fun enviaMensagem(queueName: String, message: Any) {
        rabbitTemplate.convertAndSend(queueName, message)
    }
}