package team.sfe.server.domain.user.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.user.domain.User

interface UserRepository : CrudRepository<User, Long> {

    fun findByAccountId(accountId: String): User?
}
