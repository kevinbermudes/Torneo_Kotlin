package com.example.torneo_kotlin.Rest.torneo.mappers

import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoParcialDTO
import com.example.torneo_kotlin.Rest.torneo.models.Torneos

fun CrearTorneoDTO.toEntity(): Torneos {

    // inyecta torentoRepositorio


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

fun UpdateTorneoDTO.toEntity(torneo: Torneos): Torneos {
    torneo.ubicacion = this.ubicacion ?: torneo.ubicacion
    torneo.modalidad = this.modalidad ?: torneo.modalidad
    torneo.categoriaCategoria = this.categoria ?: torneo.categoriaCategoria
    torneo.vacantes = this.cantidadParticipantes ?: torneo.vacantes
    torneo.premio = this.premio ?: torneo.premio
    torneo.fechaFin = this.fechaFin ?: torneo.fechaFin
    torneo.fechaInicio = this.fechaInicio ?: torneo.fechaInicio
    torneo.imagen = this.imagen ?: torneo.imagen

    return torneo
}

fun UpdateTorneoParcialDTO.toEntity(torneo: Torneos): Torneos {
    torneo.ubicacion = this.ubicacion ?: torneo.ubicacion
    torneo.modalidad = this.modalidad ?: torneo.modalidad
    torneo.categoriaCategoria = this.categoria ?: torneo.categoriaCategoria
    torneo.vacantes = this.cantidadParticipantes ?: torneo.vacantes
    torneo.premio = this.premio ?: torneo.premio
    torneo.fechaFin = this.fechaFin ?: torneo.fechaFin
    torneo.fechaInicio = this.fechaInicio ?: torneo.fechaInicio
    torneo.imagen = this.imagen ?: torneo.imagen

    return torneo
}