package team.sfe.server.domain.user.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.user.domain.UserEntity

interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findByAccountId(accountId: String): UserEntity?

    fun existsByAccountId(accountId: String): Boolean
}
