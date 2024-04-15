package com.example.torneo_kotlin.Rest.tenistas.mappers

import com.example.torneo_kotlin.Rest.tenistas.dto.CrearTenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.dto.TenistaDTO
import com.example.torneo_kotlin.Rest.tenistas.models.Tenista
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

fun Tenista.toDTO(): TenistaDTO = TenistaDTO(
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
        TotalDineroGanado = 0.0,
        //  al crearse no tiene victorias
        victorias = 0,
        // al crearse no tiene derrotas
        derrotas = 0,
        // los puntos iniciales seran 0
        puntos = 0,
        imagen = this.imagen
    )
}
