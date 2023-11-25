package team.sfe.server.domain.progress.presentation.dto

import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.progress.domain.KTimeLeapEntity

data class GetProgressResponse(
    val kGameManager: KGameManager,
    val kLocalDataManager: KLocalDataManager,
    val kMoneyManager: KMoneyManager,
    val kNewsManager: KNewsManager,
    val kServerDataManager: KServerDataManager,
    val kTimeManager: KTimeManager,
    val kValueManager: KValueManager,
    val lastSaveDate: String
) {
    companion object {
        fun of(gameInfoEntity: GameInfoEntity, kTimeLeapEntities: List<KTimeLeapEntity>) = GetProgressResponse(
            kGameManager = gameInfoEntity.toKGameManager(),
            kLocalDataManager = gameInfoEntity.toKLocalDataManager(),
            kMoneyManager = KMoneyManager(gameInfoEntity.money),
            kNewsManager = KNewsManager(gameInfoEntity.newsKeys),
            kServerDataManager = KServerDataManager(kTimeLeapEntities.map { it.toKTimeLeap() }),
            kTimeManager = gameInfoEntity.toKTimeManager(),
            kValueManager = gameInfoEntity.toKValueManager(),
            lastSaveDate = gameInfoEntity.lastSaveDate
        )
    }
}
