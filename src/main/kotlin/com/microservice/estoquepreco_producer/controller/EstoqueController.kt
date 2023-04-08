package com.microservice.estoquepreco_producer.controller

import com.microservice.estoquepreco_producer.dto.EstoqueDTO
import com.microservice.estoquepreco_producer.enums.RabbitMQEnums.QUEUE_ESTOQUE
import com.microservice.estoquepreco_producer.service.RabbitMQService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estoque")
class EstoqueController(
    @Autowired
    private val rabbitMQService: RabbitMQService
) {

    @PutMapping
    fun alteraEstoque(@RequestBody estoqueDTO: EstoqueDTO): ResponseEntity<EstoqueDTO>? {
        this.rabbitMQService.enviaMensagem(QUEUE_ESTOQUE.value, estoqueDTO)
        return ResponseEntity(estoqueDTO, OK)
    }
}