package team.sfe.server.domain.progress.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.progress.domain.DiseaseEntity
import team.sfe.server.domain.user.domain.UserEntity

interface DiseaseRepository : CrudRepository<DiseaseEntity, Long> {

    fun findByUserEntity(userEntity: UserEntity): DiseaseEntity?
}
