package com.example.torneo_kotlin.Rest.torneo.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "torneos")
data class Torneos(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "nombre")
    var nombre: String,
    @Column(name = "ubicacion")
    var ubicacion: String,

    @Column(name = "modalidad")
    @Enumerated(EnumType.STRING)
    var modalidad: Tipos,

    @Column(name = "categoria_categoria")
    @Enumerated(EnumType.STRING)
    var categoriaCategoria: Categoria,

    @Column(name = "vacantes")
    var vacantes: Int,
    @Column(name = "premio")
    var premio: Double,
    @Column(name = "fecha_fin")
    var fechaFin: Date,
    @Column(name = "fecha_inicio")
    var fechaInicio: Date,
    @Column(name = "imagen")
    var imagen: String,

    )

enum class Tipos {
    INDIVIDUAL, DOBLES, MIXTOS
}

enum class Categoria {
    ATP, WTA, ITF
}