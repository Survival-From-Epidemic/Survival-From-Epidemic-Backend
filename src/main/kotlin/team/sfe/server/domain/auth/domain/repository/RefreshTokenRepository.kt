package team.sfe.server.domain.auth.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.auth.domain.RefreshToken

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
    fun findByToken(token: String): RefreshToken?
}
