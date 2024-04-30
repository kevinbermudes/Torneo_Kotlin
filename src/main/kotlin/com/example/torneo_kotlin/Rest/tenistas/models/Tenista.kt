package com.example.torneo_kotlin.Rest.tenistas.models

import com.example.torneo_kotlin.Rest.torneo.models.Torneos
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tenistas")
data class Tenista(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "ranking")
    var ranking: Int,
    @Column(name = "nombre_completo")
    var nombreCompleto: String,
    @Column(name = "pais")
    var pais: String,
    @Column(name = "fecha_nacimiento")
    var fechaNacimiento: Date, // revisar si esta correcto
    @Column(name = "edad")
    var edad: Int,  // tiene que ser la resta del día actual y la fecha de nacimiento
    @Column(name = "altura")
    var altura: Double,
    @Column(name = "peso")
    var peso: Double,
    @Column(name = "ultimo_campeonato")
    var ultimoCampeonato: Date, // fecha de cuadno por última vez fue campeon
    @Enumerated(EnumType.STRING)
    @Column(name = "mano")
    var mano: Mano,
    @Enumerated(EnumType.STRING)
    @Column(name = "revez")
    var revez: Revez,
    @Column(name = "entrenador")
    var entrenador: String,
    @Column(name = "total_dinero_ganado")
    var TotalDineroGanado: Double,
    @Column(name = "victorias")
    var victorias: Int,
    @Column(name = "derrotas")
    var derrotas: Int,
    @Column(name = "puntos")
    var puntos: Int,
    @Column(name = "imagen")
    var imagen: String,

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    var torneo: Torneos? = null,

    )

enum class Mano {
    diestro, zurdo
}

enum class Revez {
    UnaMano, DosManos
}