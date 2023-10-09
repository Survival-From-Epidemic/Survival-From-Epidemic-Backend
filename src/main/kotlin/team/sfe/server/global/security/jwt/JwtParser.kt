package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import team.sfe.server.global.exception.InternalServerErrorException
import team.sfe.server.global.security.exception.ExpiredTokenException
import team.sfe.server.global.security.exception.InvalidTokenException

@Component
class JwtParser(
    private val jwtProperties: JwtProperties
) {

    fun getAuthentication(token: String): Authentication {
        TODO()
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
        } catch (exception: Exception) {
            when (exception) {
                is ExpiredJwtException -> throw ExpiredTokenException
                is JwtException -> throw InvalidTokenException
                else -> throw InternalServerErrorException
            }
        }
    }
}
