package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import team.sfe.server.domain.user.domain.type.Authority

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
        val authority: Authority = Authority.USER

        // when
        val jwt = jwtProvider.generateToken(issuer, authority)

        // then
        val parsedJwt = Jwts.parserBuilder()
            .setSigningKey(jwtProperties.secretKey)
            .build()
            .parseClaimsJws(jwt)

        Assertions.assertThat(parsedJwt.header[Header.JWT_TYPE]).isEqualTo(JwtConstant.ACCESS)
        Assertions.assertThat(parsedJwt.body.subject).isEqualTo(issuer)
        Assertions.assertThat(parsedJwt.body[JwtConstant.AUTHORITY]).isEqualTo(authority.name)
    }
}
