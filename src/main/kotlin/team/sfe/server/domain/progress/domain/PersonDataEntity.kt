package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.progress.domain.type.SymptomType
import team.sfe.server.domain.progress.presentation.dto.PersonData
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class PersonDataEntity(

    override val id: Long = 0L,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val catchData: Int,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val isInfected: Boolean,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val symptomType: SymptomType,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val deathWeight: Float,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val recoverWeight: Float
) : BaseIdEntity(id) {

    fun toPersonDataDto() = PersonData(
        catchDate = this.catchData,
        isInfected = this.isInfected,
        symptomType = this.symptomType,
        deathWeight = this.deathWeight,
        recoverWeight = this.recoverWeight
    )
}
