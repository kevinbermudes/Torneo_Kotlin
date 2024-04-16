package com.example.torneo_kotlin.Rest.torneo.controllers


import com.example.torneo_kotlin.Rest.torneo.dto.CrearTorneoDTO
import com.example.torneo_kotlin.Rest.torneo.dto.TorneoDTO
import com.example.torneo_kotlin.Rest.torneo.services.TorneoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/torneos")
class TorneoController(private val torneoService: TorneoService) {

    @GetMapping
    fun obtenerTorneos(): ResponseEntity<List<TorneoDTO>> =
        ResponseEntity.ok(torneoService.obtenerTorneos())

    @PostMapping
    fun crearTorneo(@RequestBody @Validated dto: CrearTorneoDTO): ResponseEntity<*> {
        return try {
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
    fun actualizarTorneo(@PathVariable id: Long, @RequestBody dto: CrearTorneoDTO): ResponseEntity<TorneoDTO> {
        return try {
            ResponseEntity.ok(torneoService.updateTorneo(id, dto))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
        }
    }

    @DeleteMapping("/{id}")
    fun eliminarTorneo(@PathVariable id: Long): ResponseEntity<Void> =
        ResponseEntity.noContent().also { torneoService.deleteTorneo(id) }.build()
}



