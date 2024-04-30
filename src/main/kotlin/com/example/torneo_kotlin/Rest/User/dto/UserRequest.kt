//package com.example.torneo_kotlin.Rest.User.dto
//
//import com.example.torneo_kotlin.Rest.User.models.Role
//import jakarta.validation.constraints.Email
//import jakarta.validation.constraints.NotBlank
//import jakarta.validation.constraints.NotNull
//import jakarta.validation.constraints.Size
//import org.hibernate.validator.constraints.Length
//
//
//class UserRequest {
//    @NotBlank(message = "Nombre no puede estar vacío")
//    @NotNull(message = "Nombre no puede estar vacío")
//    val nombre: String? = null
//
//    @NotBlank(message = "Apellidos no puede estar vacío")
//    @NotNull(message = "Apellidos no puede estar vacío")
//    val apellidos: String? = null
//
//    @NotNull(message = "Nombre no puede estar vacío")
//    @NotBlank(message = "Username no puede estar vacío")
//    val username: String? = null
//
//    @NotNull(message = "Email no puede estar vacío")
//    @Email(regexp = ".*@.*\\..*", message = "Email debe ser válido")
//    @NotBlank(message = "Email no puede estar vacío")
//    val email: String? = null
//
//    @NotBlank(message = "Password no puede estar vacío")
//    @Length(min = 5, message = "Password debe tener al menos 5 caracteres")
//    @Size(min = 5, message = "Password debe tener al menos 5 caracteres")
//    var password: String? = null
//    val roles: Set<Role> = setOf(Role.USER)
//    val isDeleted = false
//}