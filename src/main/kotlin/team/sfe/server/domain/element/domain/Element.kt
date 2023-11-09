package team.sfe.server.domain.element.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.element.domain.type.Type
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class Element(
    override val id: Long = 0L,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    val name: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(10)")
    val type: Type

) : BaseIdEntity(id)
