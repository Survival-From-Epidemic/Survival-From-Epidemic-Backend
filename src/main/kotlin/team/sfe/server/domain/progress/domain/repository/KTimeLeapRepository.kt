package team.sfe.server.domain.progress.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.progress.domain.KTimeLeapEntity

interface KTimeLeapRepository : CrudRepository<KTimeLeapEntity, Long> {
    fun findAllByGameInfoEntity(gameInfoEntity: GameInfoEntity): List<KTimeLeapEntity>
}
