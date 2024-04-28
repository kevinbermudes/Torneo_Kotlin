package com.example.torneo_kotlin.Rest.tenistas.dto

import com.example.torneo_kotlin.Rest.tenistas.models.Mano
import com.example.torneo_kotlin.Rest.tenistas.models.Revez
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.Length
import org.springframework.format.annotation.DateTimeFormat
import java.util.*

data class UpdateTenistaDto(

    @field:NotBlank(message = "El nombre completo no puede estar vacío")
    @field:Length(max = 100, message = "El nombre completo no puede tener más de 100 caracteres")
    @field:NotNull(message = "El nombre completo no puede ser nulo")
    val nombreCompleto: String? = null,
    @field:NotBlank(message = "El país no puede estar vacío")
    @field:Length(max = 56, message = "El país no puede tener más de 56 caracteres")
    @field:NotNull(message = "El pais no puede ser nulo")
    val pais: String? = null,
    @field:Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    val fechaNacimiento: Date? = null,
    @field:NotNull(message = "La altura no puede ser nula")
    @field:Positive(message = "La altura debe ser un valor positivo")
    val altura: Double? = null,
    @field:NotNull(message = "El peso no puede ser nulo")
    @field:Positive(message = "El peso debe ser un valor positivo")
    val peso: Double? = null,
    @field:NotNull(message = "La mano no puede ser nula")
    @field:NotBlank(message = "La mano no puede estar vacía")
    val ultimoCampeonato: Date? = null,
    @field:NotNull(message = "El revez no puede ser nulo")
    val mano: Mano? = null,
    @field:NotNull(message = "El revez no puede ser nulo")
    val revez: Revez? = null,

    @field:Positive(message = "El total de dinero ganado debe ser un valor positivo")
    val TotalDineroGanado: Double? = null,
    @field:NotNull(message = "Las victorias no pueden ser nulas")
    @field:Positive(message = "Las victorias deben ser un valor positivo")
    val victorias: Int? = null,
    @field:NotNull(message = "Las derrotas no pueden ser nulas")
    @field:Positive(message = "Las derrotas deben ser un valor positivo")
    val derrotas: Int? = null,
    @field:NotNull(message = "Los puntos no pueden ser nulos")
    @field:Positive(message = "Los puntos deben ser un valor positivo")
    val puntos: Int? = null,
    @field:NotBlank(message = "El entrenador no puede estar vacío")
    @field:Length(max = 100, message = "El entrenador no puede tener más de 100 caracteres")
    @field:NotNull(message = "El entrenador no puede ser nulo")
    val entrenador: String? = null,
    @field:NotBlank(message = "La URL de la imagen no puede estar vacía")
    @field:Length(max = 100, message = "La URL de la imagen no puede tener más de 100 caracteres")
    @field:NotNull(message = "La URL de la imagen no puede ser nula")
    val imagen: String? = null
)
