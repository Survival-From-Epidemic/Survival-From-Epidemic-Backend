package team.sfe.server.domain.auth.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefreshTokenTest {

    @Test
    fun `Refresh Token를 재발급 받는다`() {
        // given
        val refreshToken = RefreshToken(
            accountId = "강민",
            token = "token"
        )
        val updateToken = "updateToken"

        // when
        refreshToken.updateToken(updateToken)

        // then
        assertThat(refreshToken.token).isEqualTo(updateToken)
    }
}
