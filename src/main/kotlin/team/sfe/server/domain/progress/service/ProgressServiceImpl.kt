package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import team.sfe.server.domain.progress.domain.repository.GameInfoRepository
import team.sfe.server.domain.progress.domain.repository.KTimeLeapRepository
import team.sfe.server.domain.progress.exception.ProgressNotFoundException
import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
import team.sfe.server.domain.progress.presentation.dto.KLocalDataManager
import team.sfe.server.domain.progress.presentation.dto.KMoneyManager
import team.sfe.server.domain.progress.presentation.dto.KNewsManager
import team.sfe.server.domain.progress.presentation.dto.KServerDataManager
import team.sfe.server.domain.progress.presentation.dto.SaveProgressRequest
import team.sfe.server.domain.user.facade.UserFacade

@Service
class ProgressServiceImpl(
    private val userFacade: UserFacade,
    private val gameInfoRepository: GameInfoRepository,
    private val kTimeLeapRepository: KTimeLeapRepository
) : ProgressService {
    override fun saveProgress(request: SaveProgressRequest) {
        val currentUser = userFacade.getCurrentUser()

        val savedGameInfoEntity = gameInfoRepository.save(request.toGameInfoEntity(currentUser))

        kTimeLeapRepository.saveAll(request.toKTimeLeapEntity(savedGameInfoEntity))
    }

    override fun getProgress(): GetProgressResponse {
        val currentUser = userFacade.getCurrentUser()

        val gameInfoEntity = gameInfoRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException
        val kTimeLeapEntities = kTimeLeapRepository.findAllByGameInfoEntity(gameInfoEntity)

        return GetProgressResponse(
            kGameManager = gameInfoEntity.toKGameManager(),
            kLocalDataManager = KLocalDataManager(gameInfoEntity.toKLocalDataManager()),
            kMoneyManager = KMoneyManager(gameInfoEntity.money),
            kNewsManager = KNewsManager(gameInfoEntity.newsKeys),
            kServerDataManager = KServerDataManager(kTimeLeapEntities.map { it.toKTimeLeap() }),
            kTimeManager = gameInfoEntity.toKTimeManager(),
            kValueManager = gameInfoEntity.toKValueManager(),
            lastSaveDate = gameInfoEntity.lastSaveDate,
        )
    }
}
