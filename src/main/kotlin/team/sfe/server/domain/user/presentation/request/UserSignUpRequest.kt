package team.sfe.server.domain.user.presentation.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class UserSignUpRequest(
    @field:NotBlank
    @field:Size(max = 10)
    val accountId: String,

    @field:NotBlank
    @Pattern(
        regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,20}$"
    )
    val password: String
)
