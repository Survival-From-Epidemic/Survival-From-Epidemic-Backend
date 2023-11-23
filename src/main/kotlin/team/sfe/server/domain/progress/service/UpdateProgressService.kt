package team.sfe.server.domain.progress.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.sfe.server.domain.progress.domain.repository.GameInfoRepository
import team.sfe.server.domain.progress.domain.repository.PersonDataRepository
import team.sfe.server.domain.progress.exception.ProgressNotFoundException
import team.sfe.server.domain.progress.presentation.dto.UpdateProgressRequest
import team.sfe.server.domain.user.facade.UserFacade

@Service
class UpdateProgressService(
    private val userFacade: UserFacade,
    private val gameInfoRepository: GameInfoRepository,
    private val personDataRepository: PersonDataRepository
) {

    @Transactional
    fun execute(request: UpdateProgressRequest) {
        val currentUser = userFacade.getCurrentUser()

        val gameInfoEntity = gameInfoRepository.findByUserEntity(currentUser) ?: throw ProgressNotFoundException

        gameInfoEntity.updateGameInfo(
            diseaseEnabled = request.diseaseEnabled,
            pcrEnabled = request.pcrEnabled,
            kitEnabled = request.kitEnabled,
            kitChance = request.kitChance,
            vaccineResearch = request.vaccineResearch,
            vaccineEnded = request.vaccineEnded,
            etc = request.etc,
            infectWeight = request.disease.infectWeight,
            infectivity = request.disease.infectivity,
            infectPower = request.disease.infectPower,
            totalPerson = request.person.totalPerson,
            healthyPerson = request.person.healthyPerson,
            deathPerson = request.person.deathPerson,
            infectedPerson = request.person.infectedPerson
        )

        val personData = personDataRepository.findAllByUserEntity(currentUser)
        personDataRepository.deleteAll(personData)

        personDataRepository.saveAll(
            request.toPersonData(currentUser)
        )
    }
}
