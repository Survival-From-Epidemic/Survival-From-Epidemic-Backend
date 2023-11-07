package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Header.JWT_TYPE
import io.jsonwebtoken.Jws
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import team.sfe.server.global.exception.InternalServerErrorException
import team.sfe.server.global.security.auth.AuthDetailsService
import team.sfe.server.global.security.exception.ExpiredTokenException
import team.sfe.server.global.security.exception.InvalidTokenException
import team.sfe.server.global.security.jwt.JwtConstant.ACCESS

@Component
class JwtParser(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token).apply {
            if (this.header[JWT_TYPE] != ACCESS) {
                throw InvalidTokenException
            }
        }

        val userDetails = authDetailsService.loadUserByUsername(claims.body.subject)

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(jwtProperties.secretKey)
                .build()
                .parseClaimsJws(token)
        } catch (exception: Exception) {
            when (exception) {
                is ExpiredJwtException -> throw ExpiredTokenException
                is JwtException -> throw InvalidTokenException
                else -> throw InternalServerErrorException
            }
        }
    }

    fun parseToken(bearerToken: String?): String {
        if (bearerToken != null && bearerToken.startsWith(JwtConstant.PREFIX) && bearerToken.length > 7) {
            return bearerToken.substring(7)
        }
        return ""
    }
}
