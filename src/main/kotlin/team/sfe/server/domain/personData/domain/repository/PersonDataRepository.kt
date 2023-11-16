package team.sfe.server.domain.personData.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.personData.domain.PersonData

interface PersonDataRepository : CrudRepository<PersonData, Long>
