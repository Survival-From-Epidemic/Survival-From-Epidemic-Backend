package team.sfe.server.global.redis

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.redis.data")
data class RedisProperties(
    val host: String,
    val port: Int
)
