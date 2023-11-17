package team.sfe.server.domain.progress.exception

import team.sfe.server.global.error.CustomException

object ProgressNotFoundException : CustomException(404, "게임 진행 상황을 찾지 못했습니다.")
