package team.sfe.server.domain.gameInfo.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.gameInfo.domain.GameInfo

interface GameInfoRepository : CrudRepository<GameInfo, Long>
