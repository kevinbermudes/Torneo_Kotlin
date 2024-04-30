package com.example.torneo_kotlin.Rest.torneo.services

import com.example.torneo_kotlin.Rest.tenistas.dto.TenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.exceptions.TenistaNoEncontradoException
import com.example.torneo_kotlin.Rest.tenistas.mappers.toDTO
import com.example.torneo_kotlin.Rest.tenistas.models.Tenista
import com.example.torneo_kotlin.Rest.tenistas.repositories.TenistaRepositorio
import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoParcialDTO
import com.example.torneo_kotlin.Rest.torneo.exceptions.TorneoNoEncontrado
import com.example.torneo_kotlin.Rest.torneo.mappers.toDTO
import com.example.torneo_kotlin.Rest.torneo.mappers.toEntity
import com.example.torneo_kotlin.Rest.torneo.models.Torneos
import com.example.torneo_kotlin.Rest.torneo.repositories.TorneoRepositorio
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class TorneoService(
    private val torneoRepositorio: TorneoRepositorio,
    private val tenistaRepositorio: TenistaRepositorio,
) {


    fun obtenerTorneos(): List<TorneoDTO> {
        return torneoRepositorio.findAll().map { it.toDTO() }
    }


    fun createTorneo(dto: CrearTorneoDTO): TorneoDTO {
        val torneoCreado = torneoRepositorio.save(dto.toEntity()).toDTO()
        return torneoCreado
    }

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
            throw TorneoNoEncontrado("Torneo no encontrado!")
        }

        if (tenistaRepositorio.existsByTorneoId(id)) {
            throw TorneoNoEncontrado("No se puede eliminar el torneo porque está siendo utilizado por uno o más tenistas.")
        }

        torneoRepositorio.deleteById(id)
    }

    @Throws(Exception::class)
    fun inscribirTenistaEnTorneo(torneoId: Long, tenistaId: Long): TenistaDTO {
        val torneo: Torneos = torneoRepositorio.findById(torneoId).orElseThrow {
            TorneoNoEncontrado("Torneo no encontrado")
        }

        val tenista: Tenista = tenistaRepositorio.findById(tenistaId).orElseThrow {
            TenistaNoEncontradoException("Tenista no encontrado")
        }
        if (tenista.torneo?.id == torneoId) {
            throw TorneoNoEncontrado("El tenista ya está inscrito en el torneo")
        }
        if (torneo.vacantes > 0) {
            torneo.vacantes -= 1
            tenista.torneo = torneo
            torneoRepositorio.save(torneo)
            tenistaRepositorio.save(tenista)
            return tenista.toDTO()
        } else {
            throw TorneoNoEncontrado("No hay vacantes disponibles")
        }

    }


}