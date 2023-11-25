package team.sfe.server.domain.progress.domain

import jakarta.persistence.Embeddable

@Embeddable
data class KLocalDataPair(
    val key: String,
    val date: String,
)
