package team.sfe.server.domain.progress.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.user.domain.UserEntity

interface GameInfoRepository : CrudRepository<GameInfoEntity, Long> {
    fun findByUserEntity(userEntity: UserEntity): GameInfoEntity?
}
