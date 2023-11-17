package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.progress.domain.ProgressRepository
import team.sfe.server.domain.progress.exception.ProgressNotFoundException
import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
import team.sfe.server.domain.user.facade.UserFacade

@Service
class GetProgressService(
    private val userFacade: UserFacade,
    private val progressRepository: ProgressRepository
) {

    @Transactional(readOnly = true)
    fun execute(): GetProgressResponse {
        val currentUser = userFacade.getCurrentUser()

        val queryProgress = progressRepository.queryProgress(currentUser.id) ?: throw ProgressNotFoundException

        return GetProgressResponse.of(queryProgress)
    }
}
