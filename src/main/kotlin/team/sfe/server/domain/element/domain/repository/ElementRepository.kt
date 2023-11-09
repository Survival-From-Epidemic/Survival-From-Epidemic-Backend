package team.sfe.server.domain.element.domain.repository

import org.springframework.data.repository.CrudRepository
import team.sfe.server.domain.element.domain.Element

interface ElementRepository : CrudRepository<Element, Long>
