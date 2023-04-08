package com.microservice.estoquepreco_producer.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RabbitMQService(
    @Autowired
    private val rabbitTemplate: RabbitTemplate,

    @Autowired
    private val objectMapper: ObjectMapper
) {

    fun enviaMensagem(queueName: String, message: Any) {
        try {
            rabbitTemplate.convertAndSend(queueName, objectMapper.writeValueAsString(message))
        } catch (e: Exception) {
            println(e.message)
        }
    }
}