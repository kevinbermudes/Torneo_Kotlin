package com.example.torneo_kotlin.Rest.torneo.controllers


import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.UpdateTorneoParcialDTO
import com.example.torneo_kotlin.Rest.torneo.services.TorneoService
import jakarta.validation.Valid
import org.lighthousegames.logging.logging

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/torneos")
class TorneoController(private val torneoService: TorneoService) {

    private val logger = logging()

    @GetMapping
    fun obtenerTorneos(): ResponseEntity<List<TorneoDTO>> =
        ResponseEntity.ok(torneoService.obtenerTorneos())

    @PostMapping
    fun crearTorneo(@RequestBody @Validated dto: CrearTorneoDTO): ResponseEntity<*> {
        return try {
            logger.error { "Creando torneo con los datos: $dto" }
            val torneo = torneoService.createTorneo(dto)
            ResponseEntity.ok(torneo)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el torneo: ${e.message}")
        }
    }


    @GetMapping("/{id}")
    fun obtenerTorneoPorId(@PathVariable id: Long): ResponseEntity<TorneoDTO> =
        ResponseEntity.ok(torneoService.optenerTorneoPorId(id))

    @PutMapping("/{id}")
    fun updateTorneo(@PathVariable id: Long, @RequestBody @Valid dto: UpdateTorneoDTO): ResponseEntity<TorneoDTO> {
        val updatedTorneo = torneoService.updateTorneo(id, dto)
        return ResponseEntity.ok(updatedTorneo)
    }


    @PatchMapping("/{id}")
    fun updateTorneoParcial(
        @PathVariable id: Long,
        @RequestBody @Valid dto: UpdateTorneoParcialDTO
    ): ResponseEntity<TorneoDTO> {
        val updatedTorneo = torneoService.updateTorneoParcial(id, dto)
        return ResponseEntity.ok(updatedTorneo)
    }

    @DeleteMapping("/{id}")
    fun eliminarTorneo(@PathVariable id: Long): ResponseEntity<TorneoDTO> =
        ResponseEntity.noContent().also { torneoService.deleteTorneo(id) }.build()

}



