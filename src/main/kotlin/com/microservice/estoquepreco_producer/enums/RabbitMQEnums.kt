package com.microservice.estoquepreco_producer.enums

enum class RabbitMQEnums(val value: String) {
    QUEUE_ESTOQUE("ESTOQUE"),
    QUEUE_PRECO("PRECO")
}