package com.example.torneo_kotlin.Rest.torneo.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ManejadorDeExcepcionesTorneo {

    @ExceptionHandler(TorneoNoEncontrado::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun manejarTenistaNoEncontradoException(ex: TorneoNoEncontrado): Map<String, Any> {
        return mapOf("error" to ex.message.orEmpty())
    }
}
