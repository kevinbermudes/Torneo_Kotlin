package com.example.torneo_kotlin.Rest.torneo.dto

import com.example.torneo_kotlin.Rest.torneo.models.Categoria
import com.example.torneo_kotlin.Rest.torneo.models.Tipos
import jakarta.validation.constraints.*
import org.hibernate.validator.constraints.URL
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

data class CrearTorneoDTO(
    @field:NotEmpty(message = "La ubicación no puede estar vacía")
    @field:NotBlank(message = "La ubicación no puede ser unicamente espacios en blanco ")
    @field:Size(min = 3, max = 50, message = "La ubicación debe tener entre 3 y 50 caracteres")
    val ubicacion: String,

    @field:NotNull(message = "La modalidad no puede estar vacía")
    val modalidad: Tipos,

    @field:NotNull(message = "La categoría no puede estar vacía")
    val categoria: Categoria,

    @field:Positive(message = "La cantidad de vacantes debe ser un número positivo")
    @field:Min(value = 1, message = "Debe haber al menos una vacante")
    @field:NotNull(message = "La cantidad de participantes no puede estar vacía")
    val cantidadParticipantes: Int,


    @field:Positive(message = "El premio debe ser un valor positivo")
    @field:NotNull(message = "El premio no puede estar vacío")
    val premio: Double,

    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val fechaInicio: Date,

    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val fechaFin: Date,


    @field:NotBlank(message = "La URL de la imagen no puede estar vacía")
    @field:URL(message = "El formato de la URL de la imagen no es válido")
    @field:NotNull(message = "La URL de la imagen no puede estar vacía")
    @field:NotBlank(message = "La URL de la imagen no puede ser unicamente espacios en blanco")
    val imagen: String,


    )
