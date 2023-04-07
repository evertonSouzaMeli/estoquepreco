package com.microservice.estoquepreco.controller

import com.microservice.estoquepreco.dto.PrecoDTO
import com.microservice.estoquepreco.enums.RabbitMQEnums.QUEUE_PRECO
import com.microservice.estoquepreco.service.RabbitMQService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus.OK

@RestController
@RequestMapping("/preco")
class PrecoController(
    @Autowired
    private val rabbitMQService: RabbitMQService
) {

    @PutMapping
    fun alteraPreco(@RequestBody precoDTO: PrecoDTO) : ResponseEntity<PrecoDTO?> {
        println(precoDTO.codigoProduto)

        this.rabbitMQService.enviaMensagem(QUEUE_PRECO.value, precoDTO)
        return ResponseEntity(precoDTO, OK)
    }
}