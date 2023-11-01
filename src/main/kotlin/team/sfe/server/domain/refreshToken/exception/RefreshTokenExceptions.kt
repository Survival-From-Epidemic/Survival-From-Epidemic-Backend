package team.sfe.server.domain.refreshToken.exception

import team.sfe.server.global.error.CustomException

object RefreshTokenNotFoundException : CustomException(404, "Refresh Token을 찾지 못했습니다.")
