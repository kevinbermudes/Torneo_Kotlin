package com.example.torneo_kotlin.utils

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseBody
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String> {
        val errors = mutableMapOf<String, String>()
        ex.bindingResult.allErrors.forEach { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage ?: "Unknown error"
            errors[fieldName] = errorMessage
        }
        return errors
    }


    //validador para los enum
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseBody
    fun handleJsonParseException(ex: HttpMessageNotReadableException): Map<String, String> {
        val cause = ex.cause
        if (cause is InvalidFormatException && cause.targetType?.isEnum == true) {
            val field = cause.path.joinToString(".") { it.fieldName ?: it.index.toString() }
            val errorMessage =
                "Valor '${cause.value}' no válido para el campo '$field'. Valores aceptados: ${cause.targetType.enumConstants?.joinToString()}"
            return mapOf(field to errorMessage)
        }
        return mapOf("error" to "Error al procesar el JSON enviado")
    }
}