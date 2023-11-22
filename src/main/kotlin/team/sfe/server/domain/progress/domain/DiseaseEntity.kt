package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.progress.presentation.dto.Disease
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class DiseaseEntity(
    id: Long = 0L,

    @field:NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val infectWeight: Float,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val infectivity: Int,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val infectPower: Float,
) : BaseIdEntity(id) {

    fun toDiseaseDto() = Disease(
        infectWeight = this.infectWeight,
        infectivity = this.infectivity,
        infectPower = this.infectPower
    )
}
