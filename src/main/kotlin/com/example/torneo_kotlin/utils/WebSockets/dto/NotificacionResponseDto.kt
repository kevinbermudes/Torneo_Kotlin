package com.example.torneo_kotlin.utils.WebSockets.dto

import lombok.Builder

@Builder
@JvmRecord
data class NotificacionResponseDto(val entity: String, val data: String)
