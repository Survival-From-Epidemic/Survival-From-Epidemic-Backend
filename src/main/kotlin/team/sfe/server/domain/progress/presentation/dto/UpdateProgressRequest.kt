package team.sfe.server.domain.progress.presentation.dto

import team.sfe.server.domain.progress.domain.PersonDataEntity
import team.sfe.server.domain.user.domain.UserEntity

data class UpdateProgressRequest(
    val disease: Disease,
    val person: Person,
    val persons: List<PersonData>,
    val diseaseEnabled: Boolean,
    val pcrEnabled: Boolean,
    val kitEnabled: Boolean,
    val kitChance: Int,
    val vaccineResearch: Boolean,
    val vaccineEnded: Boolean,
    val etc: String
) {

    fun toPersonData(userEntity: UserEntity) = persons.map {
        PersonDataEntity(
            userEntity = userEntity,
            catchData = it.catchDate,
            isInfected = it.isInfected,
            symptomType = it.symptomType,
            deathWeight = it.deathWeight,
            recoverWeight = it.recoverWeight
        )
    }
}
