package team.sfe.server.domain.closure.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.validation.constraints.NotNull
import java.io.Serializable

@Entity
class ClosureEntity(
    @EmbeddedId
    val closureId: ClosureId,

    @field:NotNull
    @Column(columnDefinition = "TINYINT UNSIGNED")
    val depth: Int
)

@Embeddable
data class ClosureId(
    @Column(columnDefinition = "INT UNSIGNED")
    val ancestorId: Long,

    @Column(columnDefinition = "INT UNSIGNED")
    val descendantId: Long
) : Serializable
