package team.sfe.server.domain.progress.presentation.dto

import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.progress.domain.PersonDataEntity
import team.sfe.server.domain.progress.domain.type.SymptomType
import team.sfe.server.domain.user.domain.UserEntity

data class SaveProgressRequest(
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

    fun toGameInfoEntity(userEntity: UserEntity) = GameInfoEntity(
        userEntity = userEntity,
        diseaseEnabled = this.diseaseEnabled,
        pcrEnabled = this.pcrEnabled,
        kitEnabled = this.kitEnabled,
        kitChance = this.kitChance,
        vaccineResearch = this.vaccineResearch,
        vaccineEnded = this.vaccineEnded,
        etc = etc,
        infectWeight = this.disease.infectWeight,
        infectivity = this.disease.infectivity,
        infectPower = this.disease.infectPower,
        totalPerson = this.person.totalPerson,
        healthyPerson = this.person.healthyPerson,
        deathPerson = this.person.deathPerson,
        infectedPerson = this.person.infectedPerson
    )

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

data class Disease(
    val infectWeight: Float,
    val infectivity: Int,
    val infectPower: Float
)

data class Person(
    val totalPerson: Int,
    val healthyPerson: Int,
    val deathPerson: Int,
    val infectedPerson: Int
)

data class PersonData(
    val catchDate: Int,
    val isInfected: Boolean,
    val symptomType: SymptomType,
    val deathWeight: Float,
    val recoverWeight: Float
)
