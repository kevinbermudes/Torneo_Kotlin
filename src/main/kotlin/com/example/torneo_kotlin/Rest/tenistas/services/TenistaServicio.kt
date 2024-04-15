package com.example.torneo_kotlin.Rest.tenistas.services

import com.example.torneo_kotlin.Rest.tenistas.dto.CrearTenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.TenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.exceptions.TenistaNoEncontradoException
import com.example.torneo_kotlin.Rest.tenistas.mappers.toDTO
import com.example.torneo_kotlin.Rest.tenistas.mappers.toEntity
import com.example.torneo_kotlin.Rest.tenistas.repositories.TenistaRepositorio
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Transactional
@Service
class TenistaServicio(val tenistaRepositorio: TenistaRepositorio) {

    fun obtenerTenistas(): List<TenistaDTO> =
        tenistaRepositorio.findAll().map { it.toDTO() }

    fun obtenerTenistaPorId(id: Long): TenistaDTO =
        tenistaRepositorio.findById(id).orElseThrow {
            TenistaNoEncontradoException("No se pudo encontrar el tenista con ID: $id")
        }.toDTO()

    fun guardarTenista(dto: CrearTenistaDTO): TenistaDTO =
        tenistaRepositorio.save(dto.toEntity()).toDTO()

    fun eliminarTenista(id: Long) {
        if (!tenistaRepositorio.existsById(id)) {
            throw TenistaNoEncontradoException("No se pudo encontrar el tenista con ID: $id para eliminar")
        }
        tenistaRepositorio.deleteById(id)
    }

    fun actualizarTenista(id: Long, dto: TenistaDTO): TenistaDTO {
        val tenista = tenistaRepositorio.findById(id).orElseThrow {
            TenistaNoEncontradoException("No se pudo encontrar el tenista con ID: $id para actualizar")
        }
        return tenistaRepositorio.save(
            tenista.copy(
                nombreCompleto = dto.nombreCompleto,
                pais = dto.pais,
                fechaNacimiento = dto.fechaNacimiento,
                altura = dto.altura,
                peso = dto.peso,
                mano = dto.mano,
                revez = dto.revez,
                entrenador = dto.entrenador,
                imagen = dto.imagen
            )
        ).toDTO()
    }

}