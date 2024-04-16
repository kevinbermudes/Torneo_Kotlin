package com.example.torneo_kotlin.Rest.torneo.mappers

import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.models.Torneos

fun CrearTorneoDTO.toEntity(): Torneos {
    return Torneos(
        ubicacion = this.ubicacion,
        modalidad = this.modalidad,
        categoriaCategoria = this.categoria,
        vacantes = this.cantidadParticipantes,
        premio = this.premio,
        fechaFin = this.fechaFin,
        fechaInicio = this.fechaInicio,
        imagen = this.imagen
    )
}

fun Torneos.toDTO(): TorneoDTO {
    return TorneoDTO(
        id = this.id,
        ubicacion = this.ubicacion,
        modalidad = this.modalidad.name,
        categoria = this.categoriaCategoria?.name ?: "Desconocida",
        fechaInicio = this.fechaInicio,
        fechaFin = this.fechaFin,
        cantidadParticipantes = this.vacantes,
        premio = this.premio,
        imagen = this.imagen
    )
}