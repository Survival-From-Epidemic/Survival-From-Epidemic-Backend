package team.sfe.server.domain.user.presentation.response

import team.sfe.server.domain.refreshToken.domain.RefreshToken
import team.sfe.server.domain.user.domain.type.Authority

data class TokenResponse(
    val accessToken: String,
    val refreshToken: RefreshToken,
    val authority: Authority
)
