package team.sfe.server.domain.disease.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.disease.domain.Disease

interface DiseaseRepository : CrudRepository<Disease, Long>
