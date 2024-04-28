package com.example.torneo_kotlin.Rest.tenistas.dto

import com.example.torneo_kotlin.Rest.tenistas.models.Mano
import com.example.torneo_kotlin.Rest.tenistas.models.Revez
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.URL
import java.util.*

data class CrearTenistaDTO(


    @field:NotBlank(message = "El nombre completo no puede estar vacío")
    @field:Length(max = 100, message = "El nombre completo no puede tener más de 100 caracteres")
    val nombreCompleto: String,

    @field:NotBlank(message = "El país no puede estar vacío")
    @field:Length(max = 56, message = "El país no puede tener más de 56 caracteres")
    val pais: String,

    @field:Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    val fechaNacimiento: Date,

    @field:Positive(message = "La altura debe ser un valor positivo")
    val altura: Double,

    @field:Positive(message = "El peso debe ser un valor positivo")
    val peso: Double,

    @field:NotNull(message = "La mano no puede ser nula")
    val mano: Mano,

    @field:Positive(message = "El total de dinero ganado debe ser un valor positivo")
    val TotalDineroGanado: Double,
    @field:NotNull(message = "el revez no puede ser nulo")
    val revez: Revez,

    @field:NotBlank(message = "El nombre del entrenador no puede estar vacío")
    @field:Length(max = 100, message = "El nombre del entrenador no puede tener más de 100 caracteres")
    val entrenador: String,

    @field:NotBlank(message = "La URL de la imagen no puede estar vacía")
    @field:URL(message = "El formato de la URL de la imagen no es válido")
    val imagen: String
)
