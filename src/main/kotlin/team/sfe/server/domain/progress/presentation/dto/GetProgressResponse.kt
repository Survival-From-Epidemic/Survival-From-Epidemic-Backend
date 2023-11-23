package team.sfe.server.domain.progress.presentation.dto

import team.sfe.server.domain.progress.domain.vo.QueryProgressVO

data class GetProgressResponse(
    val disease: Disease,
    val person: Person,
    val persons: List<PersonData>,
    val diseaseEnabled: Boolean,
    val pcrEnabled: Boolean,
    val kitEnabled: Boolean,
    val kitChance: Int,
    val vaccineResearch: Boolean,
    val vaccineEnded: Boolean,
    val etc: String,
) {

    companion object {

        fun of(vo: QueryProgressVO) = GetProgressResponse(
            disease = vo.gameInfoEntity.toDiseaseDto(),
            person = vo.gameInfoEntity.toPersonDto(),
            persons = vo.personDataEntity.map {
                it.toPersonDataDto()
            },
            diseaseEnabled = vo.gameInfoEntity.diseaseEnabled,
            pcrEnabled = vo.gameInfoEntity.pcrEnabled,
            kitEnabled = vo.gameInfoEntity.kitEnabled,
            kitChance = vo.gameInfoEntity.kitChance,
            vaccineResearch = vo.gameInfoEntity.vaccineResearch,
            vaccineEnded = vo.gameInfoEntity.vaccineEnded,
            etc = vo.gameInfoEntity.etc
        )
    }
}
