package com.example.torneo_kotlin.Rest.tenistas.services

import com.example.torneo_kotlin.Rest.tenistas.dto.CrearTenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.TenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.UpdateTenistaDto
import com.example.torneo_kotlin.Rest.tenistas.exceptions.TenistaNoEncontradoException
import com.example.torneo_kotlin.Rest.tenistas.mappers.toDTO
import com.example.torneo_kotlin.Rest.tenistas.mappers.toEntity
import com.example.torneo_kotlin.Rest.tenistas.repositories.TenistaRepositorio
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Transactional
@Service
class TenistaServicio(val tenistaRepositorio: TenistaRepositorio) {

    fun obtenerTenistas(): List<TenistaDTO> {
        recalcularRankings()
        return tenistaRepositorio.findAll().map { it.toDTO() }
    }

    fun obtenerTenistaPorId(id: Long): TenistaDTO =
        tenistaRepositorio.findById(id).orElseThrow {
            TenistaNoEncontradoException("No se pudo encontrar el tenista con ID: $id")
        }.toDTO()

    fun guardarTenista(dto: CrearTenistaDTO): TenistaDTO {
        val tenistaGuardado = tenistaRepositorio.save(dto.toEntity())
        recalcularRankings()
        val tenistaConRanking = tenistaGuardado.id?.let { nonNullId ->
            tenistaRepositorio.findById(nonNullId).orElseThrow {
                IllegalStateException("Tenista recién guardado no encontrado.")
            }
        } ?: throw IllegalStateException("El ID del tenista guardado es nulo.")

        return tenistaConRanking.toDTO()
    }

    fun eliminarTenista(id: Long) {
        if (!tenistaRepositorio.existsById(id)) {
            throw TenistaNoEncontradoException("No se pudo encontrar el tenista con ID: $id para eliminar")
        }
        tenistaRepositorio.deleteById(id)
    }

    fun actualizarTenista(id: Long, dto: UpdateTenistaDto): TenistaDTO {
        val tenista = tenistaRepositorio.findById(id).orElseThrow {
            TenistaNoEncontradoException("No se pudo encontrar el tenista con ID: $id para actualizar")
        }
        val tenistaActualizado = dto.toEntity(tenista)
        tenistaRepositorio.save(tenistaActualizado)
        // Si se ha proporcionado un nuevo TotalDineroGanado entonces recalcule el ranking
        if (dto.TotalDineroGanado != null) {
            recalcularRankings()
        }

        return tenistaActualizado.toDTO()
    }

    private fun recalcularRankings() {
        val todosLosTenistas = tenistaRepositorio.findAll()
        val tenistasOrdenados = todosLosTenistas.sortedByDescending { it.TotalDineroGanado }
        tenistasOrdenados.forEachIndexed { index, tenista ->
            tenista.ranking = index + 1
        }
        tenistaRepositorio.saveAll(tenistasOrdenados)
    }
}