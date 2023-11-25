package team.sfe.server.domain.progress.presentation.dto

data class GetProgressResponse(
    val kGameManager: KGameManager,
    val kLocalDataManager: KLocalDataManager,
    val kMoneyManager: KMoneyManager,
    val kNewsManager: KNewsManager,
    val kServerDataManager: KServerDataManager,
    val kTimeManager: KTimeManager,
    val kValueManager: KValueManager,
    val lastSaveDate: String
) {

//    companion object {
//
//        fun of(vo: QueryProgressVO) = GetProgressResponse(
//            disease = vo.gameInfoEntity.toDiseaseDto(),
//            person = vo.gameInfoEntity.toPersonDto(),
//            persons = vo.personDataEntity.map {
//                it.toPersonDataDto()
//            },
//            diseaseEnabled = vo.gameInfoEntity.diseaseEnabled,
//            pcrEnabled = vo.gameInfoEntity.pcrEnabled,
//            kitEnabled = vo.gameInfoEntity.kitEnabled,
//            kitChance = vo.gameInfoEntity.kitChance,
//            vaccineResearch = vo.gameInfoEntity.vaccineResearch,
//            vaccineEnded = vo.gameInfoEntity.vaccineEnded,
//            etc = vo.gameInfoEntity.etc
//        )
//    }
}
