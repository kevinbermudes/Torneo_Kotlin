package com.example.torneo_kotlin.Rest.User.services


//@Service
//@CacheConfig(cacheNames = ["users"])
//class UsersServiceImp(
//    private val usersRepository: UsersRepository,
//    private val usersMapper: UsersMapper,
//    private val passwordEncoder: PasswordEncoder
//) : UsersService {
//
//    override fun findAll(
//        username: Optional<String>,
//        email: Optional<String>,
//        isDeleted: Optional<Boolean>,
//        pageable: Pageable
//    ): Page<UserResponse> {
//        val specUsernameUser = Specification<User> { root, _, criteriaBuilder ->
//            username.map { m ->
//                criteriaBuilder.like(
//                    criteriaBuilder.lower(root.get("username")),
//                    "%${m.toLowerCase()}%"
//                )
//            }
//                .orElseGet { criteriaBuilder.isTrue(criteriaBuilder.literal(true)) }
//        }
//        val specEmailUser = Specification<User> { root, _, criteriaBuilder ->
//            email.map { m -> criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%${m.toLowerCase()}%") }
//                .orElseGet { criteriaBuilder.isTrue(criteriaBuilder.literal(true)) }
//        }
//        val specIsDeleted = Specification<User> { root, _, criteriaBuilder ->
//            isDeleted.map { m -> criteriaBuilder.equal(root.get("isDeleted"), m) }
//                .orElseGet { criteriaBuilder.isTrue(criteriaBuilder.literal(true)) }
//        }
//        val criterio = Specification.where(specUsernameUser).and(specEmailUser).and(specIsDeleted)
//
//        return usersRepository.findAll(criterio, pageable).map(usersMapper::toUserResponse)
//    }
//
//    fun findById(id: Long): UserInfoResponse {
//        val user = usersRepository.findById(id).orElseThrow { UserNotFound(id) }
//        return usersMapper.toUserInfoResponse(user)
//    }
//
//    fun save(userRequest: UserRequest): UserResponse {
//        usersRepository.findByUsernameEqualsIgnoreCaseOrEmailEqualsIgnoreCase(userRequest.username, userRequest.email)
//            ?.ifPresent { throw UserNameOrEmailExists("Username o email ya existe") }
//        val passwordEncode = passwordEncoder.encode(userRequest.password)
//        userRequest.password = passwordEncode
//        return usersMapper.toUserResponse(usersRepository.save(usersMapper.toUser(userRequest)))
//    }
//
//    fun update(id: Long, userRequest: UserRequest): UserResponse {
//        usersRepository.findById(id).orElseThrow { UserNotFound(id) }
//        usersRepository.findByUsernameEqualsIgnoreCase(userRequest.username)
//            ?.ifPresent { u ->
//                if (u.id != id) {
//                    throw UserNameOrEmailExists("Username ya existe")
//                }
//            }
//        val passwordEncode = passwordEncoder.encode(userRequest.password)
//        userRequest.password = passwordEncode
//        return usersMapper.toUserResponse(usersRepository.save(usersMapper.toUser(userRequest, id)))
//    }
//
//    fun deleteById(id: Long) {
//        val user = usersRepository.findById(id).orElseThrow { UserNotFound(id) }
//        usersRepository.updateIsDeletedToTrueById(id)
//    }
//
//
//    override fun findAll(
//        username: Optional<String?>?,
//        email: Optional<String?>?,
//        isDeleted: Optional<Boolean?>?,
//        pageable: Pageable?
//    ): Page<UserResponse?>? {
//        TODO("Not yet implemented")
//    }
//
//    override fun findById(id: Long?): UserInfoResponse? {
//        TODO("Not yet implemented")
//    }
//
//    override fun save(userRequest: UserRequest?): UserResponse? {
//        TODO("Not yet implemented")
//    }
//
//    override fun update(id: Long?, userRequest: UserRequest?): UserResponse? {
//        TODO("Not yet implemented")
//    }
//
//    override fun deleteById(id: Long?) {
//        TODO("Not yet implemented")
//    }
//}
//
