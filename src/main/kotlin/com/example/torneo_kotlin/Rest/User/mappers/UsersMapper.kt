//package com.example.torneo_kotlin.Rest.User.mappers
//
//import com.example.torneo_kotlin.Rest.User.dto.UserInfoResponse
//import com.example.torneo_kotlin.Rest.User.dto.UserRequest
//import com.example.torneo_kotlin.Rest.User.dto.UserResponse
//import com.example.torneo_kotlin.Rest.User.models.User
//
//
//class UsersMapper {
//
//    fun toUser(request: UserRequest): User {
//        return User(
//            nombre = request.nombre ?: "",
//            apellidos = request.apellidos ?: "",
//            username = request.username ?: "",
//            email = request.email ?: "",
//            password = request.password ?: "",
//            roles = request.roles,
//            isDeleted = request.isDeleted
//        )
//    }
//
//    fun toUser(request: UserRequest, id: Long): User = User(
//        id = id,
//        nombre = request.nombre!!,
//        apellidos = request.apellidos!!,
//        username = request.username!!,
//        email = request.email!!,
//        password = request.password!!,
//        roles = request.roles,
//        isDeleted = request.isDeleted
//    )
//
//    fun toUserResponse(user: User): UserResponse = UserResponse(
//        id = user.id,
//        nombre = user.nombre,
//        apellidos = user.apellidos,
//        username = user.username,
//        email = user.email,
//        roles = user.roles,
//        isDeleted = user.isDeleted,
//        password = user.password
//    )
//
//    fun toUserInfoResponse(user: User, pedidos: List<String>): UserInfoResponse = UserInfoResponse(
//        id = user.id,
//        nombre = user.nombre,
//        apellidos = user.apellidos,
//        username = user.username,
//        email = user.email,
//        roles = user.roles,
//        isDeleted = user.isDeleted,
//        pedidos = pedidos,
//        password = user.password
//    )
//}