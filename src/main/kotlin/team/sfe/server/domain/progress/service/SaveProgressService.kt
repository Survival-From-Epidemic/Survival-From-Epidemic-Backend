package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.progress.domain.repository.DiseaseRepository
import team.sfe.server.domain.progress.domain.repository.GameInfoRepository
import team.sfe.server.domain.progress.domain.repository.PersonDataRepository
import team.sfe.server.domain.progress.domain.repository.PersonRepository
import team.sfe.server.domain.progress.presentation.dto.SaveProgressRequest
import team.sfe.server.domain.user.facade.UserFacade

@Service
class SaveProgressService(
    private val diseaseRepository: DiseaseRepository,
    private val gameInfoRepository: GameInfoRepository,
    private val personDataRepository: PersonDataRepository,
    private val personRepository: PersonRepository,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: SaveProgressRequest) {
        val currentUser = userFacade.getCurrentUser()

        diseaseRepository.save(
            request.disease.toDiseaseEntity(currentUser)
        )

        gameInfoRepository.save(
            request.toGameInfoEntity(currentUser)
        )

        personRepository.save(
            request.person.toPersonEntity(currentUser)
        )

        personDataRepository.saveAll(
            request.toPersonData(currentUser)
        )
    }
}
