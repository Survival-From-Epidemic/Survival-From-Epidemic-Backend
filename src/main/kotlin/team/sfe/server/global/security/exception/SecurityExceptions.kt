package team.sfe.server.global.security.exception

import team.sfe.server.global.error.CustomException

object ExpiredTokenException : CustomException(401, "만료된 JWT입니다.")
object InvalidTokenException : CustomException(401, "잘못된 JWT 토큰입니다.")
