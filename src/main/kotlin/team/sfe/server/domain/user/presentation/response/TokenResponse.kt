package team.sfe.server.domain.user.presentation.response

import team.sfe.server.domain.user.domain.type.Authority
import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiredAt: LocalDateTime,
    val refreshTokenExpiredAt: LocalDateTime,
    val authority: Authority
)
