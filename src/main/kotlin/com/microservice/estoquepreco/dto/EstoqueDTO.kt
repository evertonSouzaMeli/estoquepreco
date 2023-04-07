package com.microservice.estoquepreco.dto

import java.io.Serializable

data class EstoqueDTO (
    val codigoProduto: String,
    val quantidade: Int
): Serializable