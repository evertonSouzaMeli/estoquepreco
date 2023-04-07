package com.microservice.estoquepreco.connections

import com.microservice.estoquepreco.enums.RabbitMQEnums
import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.DirectExchange
import org.springframework.stereotype.Component

//Classe de configuração de conexão com RabbitMQ
@Component
class RabbitMQConnection(private val amqpAdmin: AmqpAdmin) {

    companion object {
        const val EXCHANGE_NAME: String = "amq.direct"
    }

     init {
        val queueStock = Queue(RabbitMQEnums.QUEUE_ESTOQUE.value, true, false, true)
        val queuePrice = Queue(RabbitMQEnums.QUEUE_PRECO.value, true, false, true)
        val directExchange = DirectExchange(EXCHANGE_NAME)

        val stockBinding = Binding(queueStock.name, Binding.DestinationType.QUEUE, directExchange.name, queueStock.name, null)
        val stockPrice = Binding(queuePrice.name, Binding.DestinationType.QUEUE, directExchange.name, queuePrice.name, null)

        amqpAdmin.declareQueue(queueStock)
        amqpAdmin.declareQueue(queuePrice)

        amqpAdmin.declareExchange(directExchange)

        amqpAdmin.declareBinding(stockBinding)
        amqpAdmin.declareBinding(stockPrice)
    }
}