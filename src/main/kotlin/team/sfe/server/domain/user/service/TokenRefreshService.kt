package team.sfe.server.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.refreshToken.domain.repository.RefreshTokenRepository
import team.sfe.server.domain.refreshToken.exception.RefreshTokenNotFoundException
import team.sfe.server.domain.user.facade.UserFacade
import team.sfe.server.domain.user.presentation.response.TokenResponse
import team.sfe.server.global.security.jwt.JwtParser
import team.sfe.server.global.security.jwt.JwtProvider

@Service
class TokenRefreshService(
    private val jwtProvider: JwtProvider,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtParser: JwtParser,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(refreshToken: String): TokenResponse {
        val redisRefreshToken = refreshTokenRepository.findByToken(jwtParser.parseToken(refreshToken))
            ?: throw RefreshTokenNotFoundException

        val user = userFacade.getUserByAccountId(redisRefreshToken.accountId)

        val newRefreshToken = jwtProvider.generateRefreshToken(redisRefreshToken.accountId)
        redisRefreshToken.updateToken(newRefreshToken.token)

        val newAccessToken = jwtProvider.generateToken(user.accountId, user.authority)

        return TokenResponse(
            accessToken = newAccessToken,
            refreshToken = newRefreshToken,
            authority = user.authority
        )
    }
}