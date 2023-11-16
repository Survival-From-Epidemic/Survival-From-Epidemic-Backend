package team.sfe.server.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.person.domain.Person
import team.sfe.server.domain.disease.domain.Disease
import team.sfe.server.domain.gameInfo.domain.GameInfo
import team.sfe.server.domain.user.domain.type.Authority
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class User(
    override val id: Long = 0L,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val accountId: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5)")
    val authority: Authority,

    @OneToOne
    @JoinColumn(name = "id")
    val disease: Disease?,

    @OneToOne
    @JoinColumn(name = "id")
    val gameInfo: GameInfo?,

    @OneToOne
    @JoinColumn(name = "id")
    val person: Person?
) : BaseIdEntity(id)
