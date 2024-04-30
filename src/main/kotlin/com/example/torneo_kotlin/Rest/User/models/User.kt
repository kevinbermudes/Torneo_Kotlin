//package com.example.torneo_kotlin.Rest.User.models
//
//import jakarta.persistence.*
//import jakarta.validation.constraints.NotBlank
//import org.hibernate.annotations.CreationTimestamp
//import org.hibernate.annotations.UpdateTimestamp
//import org.hibernate.validator.constraints.Length
//import org.springframework.data.jpa.domain.support.AuditingEntityListener
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//import java.time.LocalDateTime
//
//@Entity
//@Table(name = "USUARIOS")
//@EntityListeners(AuditingEntityListener::class)
//data class User(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long? = null,
//
//    @field:NotBlank(message = "nombre no puede estar vacío")
//    @Column(nullable = false)
//    val nombre: String,
//
//    @field:NotBlank(message = "apellidos no puede estar vacío")
//    @Column(nullable = false)
//    val apellidos: String,
//
//    @field:NotBlank(message = "Username no puede estar vacío")
//    @Column(unique = true, nullable = false)
//    val username: String,
//
//    @field:NotBlank(message = "Email no puede estar vacío")
//    @Column(unique = true, nullable = false)
//    val email: String,
//
//    @field:NotBlank(message = "Password no puede estar vacío")
//    @field:Length(min = 5, message = "Password debe tener al menos 5 caracteres")
//    @Column(nullable = false)
//    val password: String,
//
//    @CreationTimestamp
//    @Column(updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    val createdAt: LocalDateTime = LocalDateTime.now(),
//
//    @UpdateTimestamp
//    @Column(updatable = true, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    val updatedAt: LocalDateTime = LocalDateTime.now(),
//
//    @Column(columnDefinition = "boolean default false")
//    val isDeleted: Boolean = false,
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    val roles: Set<Role>
//) : UserDetails {
//    override fun getAuthorities(): Collection<GrantedAuthority> =
//        roles.map { SimpleGrantedAuthority("ROLE_" + it.name) }.toSet()
//
//    override fun getPassword(): String {
//        return password
//    }
//
//    override fun getUsername(): String = username
//
//    override fun isAccountNonExpired(): Boolean = true
//
//    override fun isAccountNonLocked(): Boolean = true
//
//    override fun isCredentialsNonExpired(): Boolean = true
//
//    override fun isEnabled(): Boolean = !isDeleted
//}
//
//
//enum class Role {
//    USER,
//    ROLE_USER,
//    ADMIN
//}

