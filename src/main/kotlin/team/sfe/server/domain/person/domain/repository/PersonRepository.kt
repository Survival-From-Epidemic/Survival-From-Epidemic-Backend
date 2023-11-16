package team.sfe.server.domain.person.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.person.domain.Person

interface PersonRepository : CrudRepository<Person, Long>
