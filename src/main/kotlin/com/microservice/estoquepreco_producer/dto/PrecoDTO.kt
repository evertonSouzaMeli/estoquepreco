package com.microservice.estoquepreco_producer.dto

import java.io.Serializable

data class PrecoDTO(
    val codigoProduto: String,
    val preco: Double
): Serializable