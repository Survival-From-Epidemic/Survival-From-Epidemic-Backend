package team.sfe.server.domain.progress.service

import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
import team.sfe.server.domain.progress.presentation.dto.SaveProgressRequest

interface ProgressService {
    fun saveProgress(request: SaveProgressRequest)

    fun getProgress(): GetProgressResponse

    fun deleteProgress()
}
