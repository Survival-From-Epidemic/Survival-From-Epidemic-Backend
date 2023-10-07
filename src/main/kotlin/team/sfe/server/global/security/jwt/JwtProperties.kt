package team.sfe.server.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties @ConstructorBinding constructor(
    val secretKey: String,
    val accessExp: Int
) {
    companion object {
        const val HEADER = "Authorization"
        const val PREFIX = "Bearer "
        const val AUTHORITY_KEY = "auth"
    }
}
