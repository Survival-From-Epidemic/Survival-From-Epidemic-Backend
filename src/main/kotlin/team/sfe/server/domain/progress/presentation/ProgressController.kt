package team.sfe.server.domain.progress.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import team.sfe.server.domain.progress.presentation.dto.GetProgressResponse
import team.sfe.server.domain.progress.presentation.dto.SaveProgressRequest
import team.sfe.server.domain.progress.service.ProgressService

@RequestMapping("/progresses")
@RestController
class ProgressController(
    private val progressService: ProgressService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun saveProgress(@RequestBody request: SaveProgressRequest) {
        progressService.saveProgress(request)
    }

    @GetMapping
    fun getProgress(): GetProgressResponse {
        return progressService.getProgress()
    }
}
