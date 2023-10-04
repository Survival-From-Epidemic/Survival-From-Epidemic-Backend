package team.sfe.server.domain

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping
    fun healthCheck() = "OK"
}
