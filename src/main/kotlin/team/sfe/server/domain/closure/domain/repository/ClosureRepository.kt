package team.sfe.server.domain.closure.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.closure.domain.Closure
import team.sfe.server.domain.closure.domain.ClosureId

interface ClosureRepository: CrudRepository<Closure,ClosureId>
