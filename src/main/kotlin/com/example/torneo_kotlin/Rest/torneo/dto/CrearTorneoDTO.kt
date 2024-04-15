package com.example.torneo_kotlin.Rest.torneo.dto

import jakarta.validation.constraints.*
import org.hibernate.validator.constraints.URL
import java.util.*

data class CrearTorneoDTO(
    @field:NotBlank(message = "La ubicación no puede estar vacía")
    val ubicacion: String,

    @field:PastOrPresent(message = "La fecha de inicio no puede ser en el futuro")
    val fechaInicio: Date,

    @field:Future(message = "La fecha de fin debe ser en el futuro")
    val fechaFin: Date,

    @field:Positive(message = "La cantidad de participantes debe ser un número positivo")
    @field:Min(value = 1, message = "Debe haber al menos un participante")
    val cantidadParticipantes: Int,

    @field:Positive(message = "El premio debe ser un valor positivo")
    val premio: Double,

    @field:NotBlank(message = "La URL de la imagen no puede estar vacía")
    @field:URL(message = "El formato de la URL de la imagen no es válido")
    val imagen: String,

    @field:NotBlank(message = "La modalidad no puede estar vacía")
    val modalidad: String,

    @field:NotBlank(message = "La categoría no puede estar vacía")
    val categoria: String
)