package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import team.sfe.server.domain.auth.domain.RefreshToken
import team.sfe.server.domain.auth.domain.repository.RefreshTokenRepository
import team.sfe.server.domain.user.domain.type.Authority
import team.sfe.server.domain.user.presentation.response.TokenResponse
import team.sfe.server.global.security.jwt.JwtConstant.ACCESS
import team.sfe.server.global.security.jwt.JwtConstant.AUTHORITY
import team.sfe.server.global.security.jwt.JwtConstant.REFRESH
import java.time.LocalDateTime
import java.util.Date

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun generateAllToken(id: String, authority: Authority): TokenResponse {
        val accessToken = generateAccessToken(id, authority)
        val refreshToken = generateRefreshToken(id, authority)

        refreshTokenRepository.save(
            RefreshToken(
                accountId = id,
                token = refreshToken
            )
        )

        return TokenResponse(
            accessToken,
            refreshToken,
            LocalDateTime.now().plusSeconds(jwtProperties.accessExp),
            LocalDateTime.now().plusSeconds(jwtProperties.refreshExp)
        )
    }

    fun generateAccessToken(id: String, authority: Authority) = generateToken(
        id,
        authority,
        ACCESS,
        jwtProperties.accessExp
    )

    fun generateRefreshToken(id: String, authority: Authority) = generateToken(
        id,
        authority,
        REFRESH,
        jwtProperties.refreshExp
    )

    private fun generateToken(id: String, authority: Authority, type: String, exp: Long) =
        Jwts.builder()
            .setHeaderParam(Header.JWT_TYPE, type)
            .setSubject(id)
            .claim(AUTHORITY, authority.name)
            .signWith(jwtProperties.secretKey, SignatureAlgorithm.HS256)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()
}
