package team.sfe.server.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(JwtProperties::class)
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secretKey: String = "",
    var accessExp: Int = 0
) {
    companion object {
        const val HEADER = "Authorization"
        const val PREFIX = "Bearer "
        const val AUTHORITY_KEY = "auth"
    }
}
