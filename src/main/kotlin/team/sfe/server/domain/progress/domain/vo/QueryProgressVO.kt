package team.sfe.server.domain.progress.domain.vo

import com.querydsl.core.annotations.QueryProjection
import team.sfe.server.domain.progress.domain.DiseaseEntity
import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.progress.domain.PersonDataEntity
import team.sfe.server.domain.progress.domain.PersonEntity

data class QueryProgressVO @QueryProjection constructor(
    val diseaseEntity: DiseaseEntity,
    val gameInfoEntity: GameInfoEntity,
    val personDataEntity: List<PersonDataEntity>,
    val personEntity: PersonEntity
)
