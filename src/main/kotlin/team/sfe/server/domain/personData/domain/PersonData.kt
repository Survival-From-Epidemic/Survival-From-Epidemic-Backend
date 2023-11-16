package team.sfe.server.domain.personData.domain

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.personData.domain.type.SymptomType
import team.sfe.server.domain.user.domain.User
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class PersonData(

    override val id: Long = 0L,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val catchData: Int,

    @field:NotNull
    @Column(columnDefinition = "BIT(1)")
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
) : BaseIdEntity(id)
