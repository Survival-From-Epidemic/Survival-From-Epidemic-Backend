package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import team.sfe.server.domain.refreshToken.domain.RefreshToken
import team.sfe.server.domain.refreshToken.domain.repository.RefreshTokenRepository
import team.sfe.server.domain.user.domain.type.Authority
import team.sfe.server.global.security.jwt.JwtConstant.ACCESS
import team.sfe.server.global.security.jwt.JwtConstant.AUTHORITY
import team.sfe.server.global.security.jwt.JwtConstant.REFRESH
import java.util.Date

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {

    fun generateToken(id: String, authority: Authority) =
        Jwts.builder()
            .setHeaderParam(Header.JWT_TYPE, ACCESS)
            .setSubject(id)
            .claim(AUTHORITY, authority.name)
            .signWith(jwtProperties.secretKey, SignatureAlgorithm.HS256)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    fun generateRefreshToken(authority: Authority) {
        val refreshToken = RefreshToken(
            token = Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, REFRESH)
                .signWith(jwtProperties.secretKey, SignatureAlgorithm.HS256)
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + jwtProperties.refreshExp * 1000))
                .compact()
        )

        refreshTokenRepository.save(refreshToken)
    }
}
