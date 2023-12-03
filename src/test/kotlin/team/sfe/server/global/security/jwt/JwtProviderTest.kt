package team.sfe.server.global.security.jwt

import io.jsonwebtoken.Header.JWT_TYPE
import io.jsonwebtoken.Jwts
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import team.sfe.server.domain.user.domain.type.Authority.USER
import team.sfe.server.global.security.jwt.JwtConstant.ACCESS
import team.sfe.server.global.security.jwt.JwtConstant.AUTHORITY
import team.sfe.server.global.security.jwt.JwtConstant.REFRESH

@ExtendWith(SpringExtension::class)
@SpringBootTest
class JwtProviderTest(
    @Autowired
    private val jwtProvider: JwtProvider,
    @Autowired
    private val jwtProperties: JwtProperties
) {

    @Test
    fun `엑세스 토큰과 리프레쉬 토큰을 생성하고, 리프레쉬 토큰은 Redis에 저장한다`() {
        // given
        val issuer = "강민"
        val authority = USER

        // when
        val tokenResponse = jwtProvider.generateAllToken(
            id = issuer,
            authority = authority
        )

        // then
        val parsedAccessToken = parsedToken(tokenResponse.accessToken)
        val parsedRefreshToken = parsedToken(tokenResponse.refreshToken)

        assertThat(parsedAccessToken.header[JWT_TYPE]).isEqualTo(ACCESS)
        assertThat(parsedAccessToken.body.subject).isEqualTo(issuer)
        assertThat(parsedRefreshToken.header[JWT_TYPE]).isEqualTo(REFRESH)
        assertThat(parsedRefreshToken.body.subject).isEqualTo(issuer)
    }

    @Test
    fun `유저의 정보를 담은 엑세스 토큰을 생성한다`() {
        // given
        val issuer = "강민"
        val authority = USER

        // when
        val accessToken = jwtProvider.generateAccessToken(id = issuer, authority = authority)

        // then
        val parsedJwt = parsedToken(accessToken)

        assertThat(parsedJwt.header[JWT_TYPE]).isEqualTo(ACCESS)
        assertThat(parsedJwt.body.subject).isEqualTo(issuer)
        assertThat(parsedJwt.body[AUTHORITY]).isEqualTo(authority.name)
    }

    @Test
    fun `엑세스 토큰을 재발급 받을 때 사용하는 리프레쉬 토큰을 생성한다`() {
        // given
        val issuer = "강민"
        val authority = USER

        // when
        val refreshToken = jwtProvider.generateRefreshToken(id = issuer, authority = authority)

        // then
        val parsedJwt = parsedToken(refreshToken)

        assertThat(parsedJwt.header[JWT_TYPE]).isEqualTo(REFRESH)
        assertThat(parsedJwt.body.subject).isEqualTo(issuer)
        assertThat(parsedJwt.body[AUTHORITY]).isEqualTo(authority.name)
    }

    private fun parsedToken(token: String) = Jwts.parserBuilder()
        .setSigningKey(jwtProperties.secretKey)
        .build()
        .parseClaimsJws(token)
}
