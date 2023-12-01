package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.progress.domain.repository.GameInfoRepository
import team.sfe.server.domain.progress.domain.repository.KTimeLeapRepository
import team.sfe.server.domain.progress.exception.ProgressNotFoundException
import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
import team.sfe.server.domain.progress.presentation.dto.SaveProgressRequest
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.domain.user.facade.UserFacade

@Transactional(readOnly = true)
@Service
class ProgressServiceImpl(
    private val userFacade: UserFacade,
    private val gameInfoRepository: GameInfoRepository,
    private val kTimeLeapRepository: KTimeLeapRepository
) : ProgressService {

    @Transactional
    override fun saveProgress(request: SaveProgressRequest) {
        val currentUser = userFacade.getCurrentUser()

        gameInfoRepository.findByUserEntity(currentUser)?.let {
            kTimeLeapRepository.deleteAllByGameInfoEntity(it)
            gameInfoRepository.deleteById(currentUser.id)
        }

        saveGameInfo(
            request = request,
            currentUser = currentUser
        )
    }

    override fun getProgress(): GetProgressResponse {
        val currentUser = userFacade.getCurrentUser()

        val gameInfoEntity = gameInfoRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException

        val kTimeLeapEntities = kTimeLeapRepository.findAllByGameInfoEntity(gameInfoEntity)

        return GetProgressResponse.of(
            gameInfoEntity = gameInfoEntity,
            kTimeLeapEntities = kTimeLeapEntities
        )
    }

    @Transactional
    override fun deleteProgress() {
        val currentUser = userFacade.getCurrentUser()

        val gameInfoEntity = gameInfoRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException

        kTimeLeapRepository.deleteAllByGameInfoEntity(gameInfoEntity)
        gameInfoRepository.deleteByUserEntity(currentUser)
    }

    private fun saveGameInfo(request: SaveProgressRequest, currentUser: UserEntity) {
        val savedGameInfoEntity = gameInfoRepository.save(request.toGameInfoEntity(currentUser))
        kTimeLeapRepository.saveAll(request.toKTimeLeapEntity(savedGameInfoEntity))
    }
}
