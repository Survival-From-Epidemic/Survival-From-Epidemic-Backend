package team.sfe.server.domain.progress.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.progress.domain.KTimeLeap

interface KTimeLeapRepository : CrudRepository<KTimeLeap, Long>
