package team.sfe.server.global.security.jwt

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    secretKey: String,
    val accessExp: Int,
    val refreshExp: Int
) {

    val secretKey = Keys.hmacShaKeyFor(secretKey.toByteArray(Charsets.UTF_8))
}
