package team.sfe.server.domain.refreshToken.domain

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 7)
class RefreshToken(
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    @Indexed
    val token: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val accountId: String,

    @field:NotNull
    @Column(columnDefinition = "INT UNSIGNED")
    val expiredAt: UInt
)
