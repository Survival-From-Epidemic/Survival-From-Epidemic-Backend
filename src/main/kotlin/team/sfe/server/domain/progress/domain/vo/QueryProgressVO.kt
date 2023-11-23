package team.sfe.server.domain.progress.domain.vo

import com.querydsl.core.annotations.QueryProjection
import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.progress.domain.PersonDataEntity

data class QueryProgressVO @QueryProjection constructor(
    val gameInfoEntity: GameInfoEntity,
    val personDataEntity: List<PersonDataEntity>
)
