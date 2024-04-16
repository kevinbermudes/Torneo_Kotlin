package com.example.torneo_kotlin.Rest.tenistas.controllers

import com.example.torneo_kotlin.Rest.tenistas.dto.CrearTenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.TenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.services.TenistaServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/tenistas")
class TenistaController @Autowired constructor(private val tenistaServicio: TenistaServicio) {

    @GetMapping
    fun listarTenistas(): ResponseEntity<List<TenistaDTO>> {
        val tenistas = tenistaServicio.obtenerTenistas()
        return ResponseEntity.ok(tenistas)
    }

    @GetMapping("/{id}")
    fun obtenerTenista(@PathVariable id: Long): ResponseEntity<TenistaDTO> {
        val tenista = tenistaServicio.obtenerTenistaPorId(id)
        return ResponseEntity.ok(tenista)
    }

    @PostMapping
    fun crearTenista(@Validated @RequestBody crearTenistaDTO: CrearTenistaDTO?): ResponseEntity<*> {
        return try {
            val tenista = tenistaServicio.guardarTenista(crearTenistaDTO!!)
            ResponseEntity.ok<TenistaDTO>(tenista)
        } catch (e: Exception) {
            // Log del error para depuración
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body<String>("Error al procesar la solicitud")
        }
    }


    @PutMapping("/{id}")
    fun actualizarTenista(@PathVariable id: Long, @RequestBody tenistaDTO: TenistaDTO): ResponseEntity<TenistaDTO> {
        val tenistaActualizado = tenistaServicio.actualizarTenista(id, tenistaDTO)
        return ResponseEntity.ok(tenistaActualizado)
    }

    @DeleteMapping("/{id}")
    fun eliminarTenista(@PathVariable id: Long): ResponseEntity<Void> {
        tenistaServicio.eliminarTenista(id)
        return ResponseEntity.noContent().build()
    }
}
