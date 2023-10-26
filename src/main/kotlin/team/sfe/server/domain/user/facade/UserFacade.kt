package team.sfe.server.domain.user.facade

import org.springframework.stereotype.Component
import team.sfe.server.domain.user.domain.User
import team.sfe.server.domain.user.domain.repository.UserRepository
import team.sfe.server.domain.user.exception.UserAlreadyExistsException
import team.sfe.server.domain.user.exception.UserNotFoundException

@Component
class UserFacade(private val userRepository: UserRepository) {

    fun isAlreadyExists(accountId: String) {
        if (userRepository.findByAccountId(accountId) != null) {
            throw UserAlreadyExistsException
        }
    }

    fun getUserByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}
