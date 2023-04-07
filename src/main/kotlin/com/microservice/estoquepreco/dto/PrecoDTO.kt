package com.microservice.estoquepreco.dto

import java.io.Serializable

data class PrecoDTO(
    val codigoProduto: String,
    val preco: Double
): Serializable