package com.example.torneo_kotlin.Rest.torneo.mappers

import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.models.Categoria
import com.example.torneo_kotlin.Rest.torneo.models.Tipos
import com.example.torneo_kotlin.Rest.torneo.models.Torneos

fun CrearTorneoDTO.toEntity(): Torneos {
    return Torneos(
        ubicacion = this.ubicacion,
        modalidad = Tipos.valueOf(this.modalidad.uppercase()),
        categoriaCategoria = Categoria.valueOf(this.categoria.uppercase()),
        vacantes = this.cantidadParticipantes,
        premio = this.premio,
        fechaFin = this.fechaFin,
        fechaInicio = this.fechaInicio,
        imagen = this.imagen
    )
}

fun Torneos.toDTO(): TorneoDTO {
    //  val safeUbicacion = this.ubicacion ?: "no disponible"

    return TorneoDTO(
        ubicacion = this.ubicacion,
        fechaInicio = this.fechaInicio,
        fechaFin = this.fechaFin,
        cantidadParticipantes = this.vacantes,
        premio = this.premio,
        imagen = this.imagen
    )
}