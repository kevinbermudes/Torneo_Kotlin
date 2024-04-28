package com.example.torneo_kotlin.Rest.torneo.services

import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoParcialDTO
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


    fun createTorneo(dto: CrearTorneoDTO): TorneoDTO =
        torneoRepositorio.save(dto.toEntity()).toDTO()

    fun optenerTorneoPorId(id: Long): TorneoDTO {
        val torneo =
            torneoRepositorio.findById(id).orElseThrow { TorneoNoEncontrado("Torneo no encontrado o torneo no existe") }
        return torneo.toDTO()
    }

    fun updateTorneo(id: Long, dto: UpdateTorneoDTO): TorneoDTO {
        val torneo = torneoRepositorio.findById(id).orElseThrow { TorneoNoEncontrado("Torneo no encontrado!") }
        val updatedTorneo = dto.toEntity(torneo)
        torneoRepositorio.save(updatedTorneo)
        return updatedTorneo.toDTO()
    }

    fun updateTorneoParcial(id: Long, dto: UpdateTorneoParcialDTO): TorneoDTO {
        val torneo = torneoRepositorio.findById(id).orElseThrow { TorneoNoEncontrado("Torneo no encontrado!") }
        val updatedTorneo = dto.toEntity(torneo)
        torneoRepositorio.save(updatedTorneo)
        return updatedTorneo.toDTO()
    }

    fun deleteTorneo(id: Long) {
        if (!torneoRepositorio.existsById(id)) {
            throw RuntimeException("Torneo no encontrado!")
        }
        torneoRepositorio.deleteById(id)
    }


    fun validarCrearTorneoDTO(dto: CrearTorneoDTO) {
        // Valida que la modalidad está dentro de los valores permitidos
        if (dto.modalidad !in Tipos.values()) {
            throw IllegalArgumentException("La modalidad especificada no es válida.")
        }

        // Valida que la categoría está dentro de los valores permitidos
        if (dto.categoria !in Categoria.values()) {
            throw IllegalArgumentException("La categoría especificada no es válida.")
        }

        // Otros campos pueden ser validados según sea necesario
    }

}