package team.sfe.server.domain.user.presentation

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import team.sfe.server.domain.user.presentation.request.UserSignUpRequest
import team.sfe.server.domain.user.presentation.response.TokenResponse
import team.sfe.server.domain.user.service.UserSignUpService

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(
        @RequestBody @Valid
        request: UserSignUpRequest
    ): TokenResponse {
        return userSignUpService.execute(request)
    }
}
