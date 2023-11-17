package team.sfe.server.domain.progress.service

import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse

interface GetProgressService {
    fun execute(): GetProgressResponse
}
