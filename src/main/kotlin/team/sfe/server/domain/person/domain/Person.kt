package team.sfe.server.domain.person.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class Person(
    override val id: Long = 0L,

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
    val infectedPerson: Int
) : BaseIdEntity(id)
