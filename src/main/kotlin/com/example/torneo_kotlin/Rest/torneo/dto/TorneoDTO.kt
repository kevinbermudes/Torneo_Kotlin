package com.example.torneo_kotlin.Rest.torneo.dto

import java.util.*

data class TorneoDTO(
    var id: Long? = null,
    val ubicacion: String,
    val nombre: String,
    val modalidad: String,
    val categoria: String,
    val fechaInicio: Date,
    val fechaFin: Date,
    val vacantes: Int,
    val premio: Double,
    val imagen: String
)
