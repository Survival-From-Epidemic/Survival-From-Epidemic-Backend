package team.sfe.server.domain.gameInfo.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class GameInfo(
    override val id: Long = 0L,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val diseaseEnable: Boolean,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val pcrEnable: Boolean,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val kitEnable: Boolean,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val kitChance: Int,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val vaccineReserch: Boolean,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val vaccineEnded: Boolean
) : BaseIdEntity(id)
