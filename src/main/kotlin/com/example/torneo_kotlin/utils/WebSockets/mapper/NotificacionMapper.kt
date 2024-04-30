package com.example.torneo_kotlin.utils.WebSockets.mapper

import com.example.torneo_kotlin.utils.WebSockets.dto.NotificacionResponseDto
import org.springframework.stereotype.Component


@Component
class NotificacionMapper<T> {

    fun getNotificacionResponseDto(t: T, entity: String?): NotificacionResponseDto {

        val entityString = entity ?: "default"

        return NotificacionResponseDto(
            entity = entityString,
            data = t.toString()
        )
    }
}


