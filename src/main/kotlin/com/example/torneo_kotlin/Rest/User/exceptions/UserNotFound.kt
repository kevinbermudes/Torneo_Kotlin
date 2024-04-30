package com.example.torneo_kotlin.Rest.User.exceptions


class UserNotFound : UserException {
    constructor(message: String?) : super(message)
    constructor(id: Long) : super("Usuario con id $id no encontrado")
}

