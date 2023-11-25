package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import team.sfe.server.domain.progress.domain.repository.GameInfoRepository
import team.sfe.server.domain.progress.domain.repository.KTimeLeapRepository
import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
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
        TODO("Not yet implemented")
    }
}
