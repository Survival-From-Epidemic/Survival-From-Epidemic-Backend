package team.sfe.server.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class User(
    override val id: Long,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val accountId: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String

) : BaseIdEntity(id)
