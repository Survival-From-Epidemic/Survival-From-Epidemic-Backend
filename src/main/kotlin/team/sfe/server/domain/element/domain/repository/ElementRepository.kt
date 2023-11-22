package team.sfe.server.domain.element.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.element.domain.ElementEntity

interface ElementRepository : CrudRepository<ElementEntity, Long>
