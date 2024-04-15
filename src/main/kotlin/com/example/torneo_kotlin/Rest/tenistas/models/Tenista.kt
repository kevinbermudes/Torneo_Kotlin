package com.example.torneo_kotlin.Rest.tenistas.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tenistas")
data class Tenista(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "ranking")
    val ranking: Long,
    @Column(name = "nombre_completo")
    val nombreCompleto: String,
    @Column(name = "pais")
    val pais: String,
    @Column(name = "fecha_nacimiento")
    val fechaNacimiento: Date, // revisar si esta correcto
    @Column(name = "edad")
    val edad: Int,  // tiene que ser la resta del día actual y la fecha de nacimiento
    @Column(name = "altura")
    val altura: Double,
    @Column(name = "peso")
    val peso: Double,
    @Column(name = "ultimo_campeonato")
    val ultimoCampeonato: Date, // fecha de cuadno por última vez fue campeon
    @Enumerated(EnumType.STRING)
    @Column(name = "mano")
    val mano: Mano,
    @Enumerated(EnumType.STRING)
    @Column(name = "revez")
    val revez: Revez,
    @Column(name = "entrenador")
    val entrenador: String,
    @Column(name = "total_dinero_ganado")
    val TotalDineroGanado: Double,
    @Column(name = "victorias")
    val victorias: Int,
    @Column(name = "derrotas")
    val derrotas: Int,
    @Column(name = "puntos")
    val puntos: Int,
    @Column(name = "imagen")
    val imagen: String

)

enum class Mano {
    diestro, zurdo
}

enum class Revez {
    UnaMano, DosManos
}