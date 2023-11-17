package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class GameInfoEntity(
    override val id: Long = 0L,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val diseaseEnabled: Boolean,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val pcrEnabled: Boolean,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val kitEnabled: Boolean,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val kitChance: Int,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val vaccineResearch: Boolean,

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    val vaccineEnded: Boolean
) : BaseIdEntity(id)
