package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import team.sfe.server.domain.user.domain.type.Authority
import java.util.Date

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties
) {
    fun generateToken(id: String, authority: Authority) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(id)
            .claim(JwtProperties.AUTHORITY_KEY, authority)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()
}
