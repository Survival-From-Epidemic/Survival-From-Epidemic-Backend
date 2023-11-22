package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.progress.domain.repository.DiseaseRepository
import team.sfe.server.domain.progress.domain.repository.GameInfoRepository
import team.sfe.server.domain.progress.domain.repository.PersonDataRepository
import team.sfe.server.domain.progress.domain.repository.PersonRepository
import team.sfe.server.domain.progress.exception.ProgressNotFoundException
import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
import team.sfe.server.domain.user.facade.UserFacade

@Service
class GetProgressServiceImpl(
    private val userFacade: UserFacade,
    private val diseaseRepository: DiseaseRepository,
    private val gameInfoRepository: GameInfoRepository,
    private val personDataRepository: PersonDataRepository,
    private val personRepository: PersonRepository,
) : GetProgressService {

    @Transactional(readOnly = true)
    override fun execute(): GetProgressResponse {
        val currentUser = userFacade.getCurrentUser()

        val diseaseEntity = diseaseRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException

        val gameInfoEntity = gameInfoRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException

        val personData = personDataRepository.findAllByUserEntity(currentUser)

        val personEntity = personRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException

        return GetProgressResponse(
            disease = diseaseEntity.toDiseaseDto(),
            person = personEntity.toPersonDto(),
            persons = personData.map { it.toPersonDataDto() },
            diseaseEnabled = gameInfoEntity.diseaseEnabled,
            pcrEnabled = gameInfoEntity.pcrEnabled,
            kitEnabled = gameInfoEntity.kitEnabled,
            kitChance = gameInfoEntity.kitChance,
            vaccineResearch = gameInfoEntity.vaccineResearch,
            vaccineEnded = gameInfoEntity.vaccineEnded,
            etc = gameInfoEntity.etc,
        )
    }
}
