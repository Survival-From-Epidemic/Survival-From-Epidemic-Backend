package team.sfe.server.domain.user.presentation

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import team.sfe.server.domain.user.presentation.request.UserSignInRequest
import team.sfe.server.domain.user.presentation.request.UserSignUpRequest
import team.sfe.server.domain.user.presentation.response.TokenResponse
import team.sfe.server.domain.user.service.TokenRefreshService
import team.sfe.server.domain.user.service.UserSignInService
import team.sfe.server.domain.user.service.UserSignUpService

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
    private val userSignInService: UserSignInService,
    private val tokenRefreshService: TokenRefreshService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(
        @RequestBody @Valid
        request: UserSignUpRequest
    ): TokenResponse {
        return userSignUpService.execute(request)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/tokens")
    fun signIn(
        @RequestBody @Valid
        request: UserSignInRequest
    ): TokenResponse {
        return userSignInService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/tokens")
    fun reissue(@RequestHeader("Refresh-Token") refreshToken: String): TokenResponse {
        return tokenRefreshService.execute(refreshToken)
    }
}
