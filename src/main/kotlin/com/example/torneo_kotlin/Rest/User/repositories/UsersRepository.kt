//package com.example.torneo_kotlin.Rest.User.repositories
//
//import com.example.torneo_kotlin.Rest.User.models.User
//import jakarta.transaction.Transactional
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor
//import org.springframework.data.jpa.repository.Modifying
//import org.springframework.data.jpa.repository.Query
//import org.springframework.stereotype.Repository
//import java.util.*
//
//
//@Repository
//interface UsersRepository : JpaRepository<User?, Long?>, JpaSpecificationExecutor<User?> {
//    fun findByUsername(username: String?): Optional<User?>?
//    fun findByEmail(email: String?): Optional<User?>?
//    fun findByUsernameEqualsIgnoreCase(username: String?): Optional<User?>?
//    fun findByUsernameEqualsIgnoreCaseOrEmailEqualsIgnoreCase(username: String?, email: String?): Optional<User?>?
//    fun findAllByUsernameContainingIgnoreCase(username: String?): List<User?>?
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE User p SET p.isDeleted = true WHERE p.id = :id")
//    fun updateIsDeletedToTrueById(id: Long?)
//}
//
