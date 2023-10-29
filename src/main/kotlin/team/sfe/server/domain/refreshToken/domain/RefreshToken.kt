package team.sfe.server.domain.refreshToken.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 14)
class RefreshToken(
    @Id
    val token: String
)
