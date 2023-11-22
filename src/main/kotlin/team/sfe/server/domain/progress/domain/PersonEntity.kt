package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.progress.presentation.dto.Person
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class PersonEntity(
    id: Long = 0L,

    @field:NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val totalPerson: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val healthyPerson: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val deathPerson: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val infectedPerson: Int,
) : BaseIdEntity(id) {

    fun toPersonDto() = Person(
        totalPerson = this.totalPerson,
        healthyPerson = this.healthyPerson,
        deathPerson = this.deathPerson,
        infectedPerson = this.infectedPerson
    )
}
