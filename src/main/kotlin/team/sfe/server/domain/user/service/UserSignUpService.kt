package team.sfe.server.domain.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.user.domain.User
import team.sfe.server.domain.user.domain.repository.UserRepository
import team.sfe.server.domain.user.domain.type.Authority
import team.sfe.server.domain.user.facade.UserFacade
import team.sfe.server.domain.user.presentation.request.UserSignUpRequest

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UserSignUpRequest) {
        userFacade.isAlreadyExists(request.accountId)

        userRepository.save(
            User(
                id = 0,
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                authority = Authority.USER
            )
        )
    }
}
