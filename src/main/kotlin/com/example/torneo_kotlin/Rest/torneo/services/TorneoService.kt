package com.example.torneo_kotlin.Rest.torneo.services

import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.exceptions.TorneoNoEncontrado
import com.example.torneo_kotlin.Rest.torneo.mappers.toDTO
import com.example.torneo_kotlin.Rest.torneo.mappers.toEntity
import com.example.torneo_kotlin.Rest.torneo.models.Categoria
import com.example.torneo_kotlin.Rest.torneo.models.Tipos
import com.example.torneo_kotlin.Rest.torneo.repositories.TorneoRepositorio
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TorneoService(private val torneoRepositorio: TorneoRepositorio) {

    fun obtenerTorneos(): List<TorneoDTO> {
        return torneoRepositorio.findAll().map { it.toDTO() }
    }

    fun createTorneo(dto: CrearTorneoDTO): TorneoDTO {
        val torneo = dto.toEntity()
        torneoRepositorio.save(torneo)
        return torneo.toDTO()
    }

    fun optenerTorneoPorId(id: Long): TorneoDTO {
        val torneo = torneoRepositorio.findById(id).orElseThrow { TorneoNoEncontrado("Torneo no encontrado!") }
        return torneo.toDTO()
    }

    fun updateTorneo(id: Long, dto: CrearTorneoDTO): TorneoDTO {
        val torneo = torneoRepositorio.findById(id).orElseThrow { TorneoNoEncontrado("Torneo no encontrado!") }

        torneo.ubicacion = dto.ubicacion
        torneo.modalidad = Tipos.valueOf(dto.modalidad)
        torneo.categoriaCategoria = Categoria.valueOf(dto.categoria)
        torneo.vacantes = dto.cantidadParticipantes
        torneo.premio = dto.premio
        torneo.fechaFin = dto.fechaFin
        torneo.fechaInicio = dto.fechaInicio
        torneo.imagen = dto.imagen

        torneoRepositorio.save(torneo)
        return torneo.toDTO()
    }

    fun deleteTorneo(id: Long) {
        if (!torneoRepositorio.existsById(id)) {
            throw RuntimeException("Torneo no encontrado!")
        }
        torneoRepositorio.deleteById(id)
    }


}