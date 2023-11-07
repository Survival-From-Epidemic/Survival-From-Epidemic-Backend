package team.sfe.server.domain.user.exception

import team.sfe.server.global.error.CustomException

object PasswordMisMatchException : CustomException(401, "패스워드가 일치하지 않습니다.")

object UserNotFoundException : CustomException(404, "유저를 찾지 못했습니다.")

object UserAlreadyExistsException : CustomException(409, "유저가 이미 존재합니다.")
