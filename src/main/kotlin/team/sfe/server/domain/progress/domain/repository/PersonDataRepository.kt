package team.sfe.server.domain.progress.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.progress.domain.PersonDataEntity
import team.sfe.server.domain.user.domain.UserEntity

interface PersonDataRepository : CrudRepository<PersonDataEntity, Long> {

    fun findAllByUserEntity(userEntity: UserEntity): List<PersonDataEntity>
}
