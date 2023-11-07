package team.sfe.server.domain.auth.exception

import team.sfe.server.global.error.CustomException

object RefreshTokenNotFoundException : CustomException(404, "Refresh Token을 찾지 못했습니다.")

object PasswordMisMatchException : CustomException(401, "패스워드가 일치하지 않습니다.")
