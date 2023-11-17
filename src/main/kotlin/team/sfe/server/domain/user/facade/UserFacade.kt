package team.sfe.server.domain.user.facade

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.domain.user.domain.repository.UserRepository
import team.sfe.server.domain.user.exception.UserAlreadyExistsException
import team.sfe.server.domain.user.exception.UserNotFoundException

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun isUserAlreadyExists(accountId: String) {
        if (userRepository.existsByAccountId(accountId)) {
            throw UserAlreadyExistsException
        }
    }

    fun getUserByAccountId(accountId: String): UserEntity {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }

    fun getCurrentUser(): UserEntity {
        val id = SecurityContextHolder.getContext().authentication.name.toLong()
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException
    }
}
