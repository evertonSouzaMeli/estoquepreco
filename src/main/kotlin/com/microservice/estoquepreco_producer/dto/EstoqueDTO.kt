package com.microservice.estoquepreco_producer.dto

import java.io.Serializable

data class EstoqueDTO (
    val codigoProduto: String,
    val quantidade: Int
): Serializable