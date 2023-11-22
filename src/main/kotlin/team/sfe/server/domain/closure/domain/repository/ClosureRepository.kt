package team.sfe.server.domain.closure.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.closure.domain.ClosureEntity
import team.sfe.server.domain.closure.domain.ClosureId

interface ClosureRepository : CrudRepository<ClosureEntity, ClosureId>
