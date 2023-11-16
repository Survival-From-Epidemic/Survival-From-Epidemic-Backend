package team.sfe.server.domain.disease.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class Disease(
    override val id: Long = 0L,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val infectWeight: Float,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val infectivity: Int,

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    val infectPower: Float
) : BaseIdEntity(id)
