package com.example.torneo_kotlin.Rest.tenistas.mappers

import com.example.torneo_kotlin.Rest.tenistas.dto.CrearTenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.TenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.UpdateTenistaDto
import com.example.torneo_kotlin.Rest.tenistas.models.Tenista
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

fun Tenista.toDTO(): TenistaDTO {
    return TenistaDTO(
        ranking = this.ranking,
        nombreCompleto = this.nombreCompleto,
        pais = this.pais,
        fechaNacimiento = this.fechaNacimiento,
        edad = this.edad,
        altura = this.altura,
        peso = this.peso,
        ultimoCampeonato = this.ultimoCampeonato,
        mano = this.mano,
        revez = this.revez,
        entrenador = this.entrenador,
        totalDineroGanado = this.TotalDineroGanado,
        victorias = this.victorias,
        derrotas = this.derrotas,
        puntos = this.puntos,
        imagen = this.imagen
    )
}

fun CrearTenistaDTO.toEntity(): Tenista {
    val fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()


    val edadCalculada = Period.between(fechaNacimientoLocal, LocalDate.now()).years

    return Tenista(
        // El ranking sera 0 ya que al inscribirse no tiene ranking ni puntos poco a poco se ira sumando
        ranking = 0,
        nombreCompleto = this.nombreCompleto,
        pais = this.pais,
        fechaNacimiento = this.fechaNacimiento,
        edad = edadCalculada,
        altura = this.altura,
        peso = this.peso,
        ultimoCampeonato = Date(),// revisar
        mano = this.mano,
        revez = this.revez,
        entrenador = this.entrenador,
        // de igual manera el dinero ganado sera 0 ya que no ha ganado nada
        TotalDineroGanado = this.TotalDineroGanado,
        //  al crearse no tiene victorias
        victorias = 0,
        // al crearse no tiene derrotas
        derrotas = 0,
        // los puntos iniciales seran 0
        puntos = 0,
        imagen = this.imagen
    )
}

fun UpdateTenistaDto.toEntity(tenista: Tenista): Tenista {
    fechaNacimiento?.let {
        val fechaNacimientoLocal = it.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        tenista.edad = Period.between(fechaNacimientoLocal, LocalDate.now()).years
    }

    tenista.nombreCompleto = nombreCompleto ?: tenista.nombreCompleto
    tenista.pais = pais ?: tenista.pais
    tenista.fechaNacimiento = fechaNacimiento ?: tenista.fechaNacimiento
    tenista.altura = altura ?: tenista.altura
    tenista.peso = peso ?: tenista.peso
    tenista.ultimoCampeonato = ultimoCampeonato ?: tenista.ultimoCampeonato
    tenista.mano = mano ?: tenista.mano
    tenista.revez = revez ?: tenista.revez
    tenista.entrenador = entrenador ?: tenista.entrenador
    tenista.victorias = victorias ?: tenista.victorias
    tenista.derrotas = derrotas ?: tenista.derrotas
    tenista.puntos = (victorias ?: tenista.victorias) * 10
    tenista.imagen = imagen ?: tenista.imagen
    if (TotalDineroGanado != null) {
        tenista.TotalDineroGanado = TotalDineroGanado
    }
    return tenista
}

