package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Header.JWT_TYPE
import io.jsonwebtoken.Jwts
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import team.sfe.server.domain.user.domain.type.Authority.USER

class JwtProviderTest {

    @Test
    fun `유저의 정보를 담은 access_token을 생성한다`() {
        // given
        val jwtProperties = JwtProperties(
            secretKey = "abcdabcdabcdabcdabcdabcdabcdabcd",
            accessExp = 1800
        )
        val jwtProvider = JwtProvider(jwtProperties)
        val issuer = "강민"
        val authority = USER

        // when
        val jwt = jwtProvider.generateToken(issuer, authority)

        // then
        val parsedJwt = Jwts.parserBuilder()
            .setSigningKey(jwtProperties.secretKey)
            .build()
            .parseClaimsJws(jwt)

        assertThat(parsedJwt.header[JWT_TYPE]).isEqualTo(JwtConstant.ACCESS)
        assertThat(parsedJwt.body.subject).isEqualTo(issuer)
        assertThat(parsedJwt.body[JwtConstant.AUTHORITY]).isEqualTo(authority.name)
    }
}
