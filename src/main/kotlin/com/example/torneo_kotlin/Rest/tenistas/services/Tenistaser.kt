package com.example.torneo_kotlin.Rest.tenistas.services

import com.example.torneo_kotlin.Rest.tenistas.models.Tenista
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface Tenistaser {
    fun findAll(
        nombre: Optional<String?>?,
        isActivo: Optional<Boolean?>?,
        categoria: Optional<String?>?,
        pageable: Pageable?
    ): Page<Tenista?>?

    fun updateImage(id: String?, image: MultipartFile?, withUrl: Boolean?): Tenista?

}