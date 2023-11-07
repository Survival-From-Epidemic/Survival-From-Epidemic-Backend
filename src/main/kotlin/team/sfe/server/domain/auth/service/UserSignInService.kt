package team.sfe.server.domain.auth.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.auth.exception.PasswordMisMatchException
import team.sfe.server.domain.user.facade.UserFacade
import team.sfe.server.domain.user.presentation.request.UserSignInRequest
import team.sfe.server.domain.user.presentation.response.TokenResponse
import team.sfe.server.global.security.jwt.JwtProvider

@Service
class UserSignInService(
    private val userFacade: UserFacade,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: UserSignInRequest): TokenResponse {
        val user = userFacade.getUserByAccountId(request.accountId)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatchException
        }

        return jwtProvider.generateAllToken(user.accountId, user.authority)
    }
}
