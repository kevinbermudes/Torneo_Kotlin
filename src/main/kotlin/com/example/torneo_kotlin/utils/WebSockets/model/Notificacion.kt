package com.example.torneo_kotlin.utils.WebSockets.model

import lombok.Builder


@Builder
@JvmRecord
data class Notificacion<T>(val entity: String, val tipo: Tipo, val data: T, val createdAt: String) {
    enum class Tipo {
        CREATE,
        UPDATE,
        DELETE
    }
}

