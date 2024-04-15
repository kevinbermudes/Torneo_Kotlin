package com.example.torneo_kotlin.Rest.torneo.repositories

import com.example.torneo_kotlin.Rest.torneo.models.Torneos
import org.springframework.data.repository.CrudRepository

interface TorneoRepositorio : CrudRepository<Torneos, Long> {
}