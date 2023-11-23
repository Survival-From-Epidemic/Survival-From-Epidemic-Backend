package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
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

    catchData: Int,

    isInfected: Boolean,

    symptomType: SymptomType,

    deathWeight: Float,

    recoverWeight: Float
) : BaseIdEntity(id) {

    @field:NotNull
    @Column(columnDefinition = "INT")
    var catchData = catchData
        protected set

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var isInfected = isInfected
        protected set

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    var symptomType = symptomType
        protected set

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    var deathWeight = deathWeight
        protected set

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    var recoverWeight = recoverWeight
        protected set

    fun updatePersonData(
        catchData: Int,
        isInfected: Boolean,
        symptomType: SymptomType,
        deathWeight: Float,
        recoverWeight: Float
    ) {
        this.catchData = catchData
        this.isInfected = isInfected
        this.symptomType = symptomType
        this.deathWeight = deathWeight
        this.recoverWeight = recoverWeight
    }

    fun toPersonDataDto() = PersonData(
        catchDate = this.catchData,
        isInfected = this.isInfected,
        symptomType = this.symptomType,
        deathWeight = this.deathWeight,
        recoverWeight = this.recoverWeight
    )
}
