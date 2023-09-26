package team.sfe.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SurvivalFromEpidemicBackendApplication

fun main(args: Array<String>) {
    runApplication<SurvivalFromEpidemicBackendApplication>(*args)
}
