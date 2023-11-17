package team.sfe.server.domain.progress.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.progress.domain.PersonEntity
import team.sfe.server.domain.user.domain.UserEntity

interface PersonRepository : CrudRepository<PersonEntity, Long> {

    fun findByUserEntity(userEntity: UserEntity): PersonEntity?
}
