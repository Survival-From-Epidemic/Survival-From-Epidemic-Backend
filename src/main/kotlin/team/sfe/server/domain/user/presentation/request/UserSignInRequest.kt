package team.sfe.server.domain.user.presentation.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class UserSignInRequest(
    @field:NotBlank
    val accountId: String,

    @field:NotBlank
    @Pattern(
        regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+-=?/])[a-zA-Z0-9~!@#$%^&*()_+-=?/]{8,20}$",
        message = "비밀번호는는 8자에서 20자 사이입니다."
    )
    val password: String
)
