package com.example.torneo_kotlin.Rest.tenistas.dto

import com.example.torneo_kotlin.Rest.tenistas.models.Mano
import com.example.torneo_kotlin.Rest.tenistas.models.Revez
import java.util.*

data class TenistaDTO(
    val id: Long,
    val ranking: Int,
    val nombreCompleto: String,
    val pais: String,
    val fechaNacimiento: Date,
    val edad: Int,
    val altura: Double,
    val peso: Double,
    val ultimoCampeonato: Date,
    val mano: Mano,
    val revez: Revez,
    val entrenador: String,
    val totalDineroGanado: Double,
    val victorias: Int,
    val derrotas: Int,
    val puntos: Int,
    val imagen: String,
    val nombreTorneo: String
)
