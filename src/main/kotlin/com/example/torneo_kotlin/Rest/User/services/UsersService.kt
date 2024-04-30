//package com.example.torneo_kotlin.Rest.User.services
//
//import com.example.torneo_kotlin.Rest.User.dto.UserInfoResponse
//import com.example.torneo_kotlin.Rest.User.dto.UserRequest
//import com.example.torneo_kotlin.Rest.User.dto.UserResponse
//import org.springframework.data.domain.Page
//import org.springframework.data.domain.Pageable
//import java.util.*
//
//
//interface UsersService {
//    fun findAll(
//        username: Optional<String?>?,
//        email: Optional<String?>?,
//        isDeleted: Optional<Boolean?>?,
//        pageable: Pageable?
//    ): Page<UserResponse?>?
//
//    fun findById(id: Long?): UserInfoResponse?
//    fun save(userRequest: UserRequest?): UserResponse?
//    fun update(id: Long?, userRequest: UserRequest?): UserResponse?
//    fun deleteById(id: Long?)
//}
//
