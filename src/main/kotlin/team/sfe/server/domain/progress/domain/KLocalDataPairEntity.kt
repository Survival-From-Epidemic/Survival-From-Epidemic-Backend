package team.sfe.server.domain.progress.domain

import jakarta.persistence.Embeddable

@Embeddable
data class KLocalDataPairEntity(
    val pairKey: String,
    val date: String
)
