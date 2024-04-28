package com.example.torneo_kotlin.Rest.tenistas.repositories

import com.example.torneo_kotlin.Rest.tenistas.models.Tenista
import org.springframework.data.jpa.repository.JpaRepository

interface TenistaRepositorio : JpaRepository<Tenista, Long> {

}