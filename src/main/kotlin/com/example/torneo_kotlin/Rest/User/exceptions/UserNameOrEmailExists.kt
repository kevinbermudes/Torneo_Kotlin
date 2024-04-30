package com.example.torneo_kotlin.Rest.User.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNameOrEmailExists(message: String?) : UserException(message)