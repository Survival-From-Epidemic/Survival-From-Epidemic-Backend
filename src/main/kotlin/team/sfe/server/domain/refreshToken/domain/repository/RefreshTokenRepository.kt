package team.sfe.server.domain.refreshToken.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.refreshToken.domain.RefreshToken

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>
