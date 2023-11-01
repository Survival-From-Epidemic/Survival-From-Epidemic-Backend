package team.sfe.server.domain

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/health-check")
@RestController
class HealthCheckController {

    @GetMapping
    fun healthCheck() = "OK"
}
