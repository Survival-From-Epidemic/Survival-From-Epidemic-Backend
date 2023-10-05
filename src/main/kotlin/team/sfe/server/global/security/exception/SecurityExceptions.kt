package team.sfe.server.global.security.exception

import team.sfe.server.global.error.CustomException

object ExpiredTokenException : CustomException(401, SecurityMessage.EXPIRED_TOKEN)
object InvalidTokenException : CustomException(401, SecurityMessage.INVALID_TOKEN)

private object SecurityMessage {
    const val EXPIRED_TOKEN = "만료된 JWT입니다."
    const val INVALID_TOKEN = "잘못된 JWT 토큰입니다."
}
