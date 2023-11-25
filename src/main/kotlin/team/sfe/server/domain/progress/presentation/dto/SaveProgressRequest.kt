package team.sfe.server.domain.progress.presentation.dto

import team.sfe.server.domain.progress.domain.GameInfoEntity
import team.sfe.server.domain.progress.domain.KLocalDataPairEntity
import team.sfe.server.domain.progress.domain.KTimeLeapEntity
import team.sfe.server.domain.progress.domain.type.GameEndType
import team.sfe.server.domain.user.domain.UserEntity

data class SaveProgressRequest(
    val kGameManager: KGameManager,
    val kLocalDataManager: KLocalDataManager,
    val kMoneyManager: KMoneyManager,
    val kNewsManager: KNewsManager,
    val kServerDataManager: KServerDataManager,
    val kTimeManager: KTimeManager,
    val kValueManager: KValueManager,
    val lastSaveDate: String
) {
    fun toGameInfoEntity(userEntity: UserEntity) = GameInfoEntity(
        userEntity = userEntity,
        gameEnd = this.kGameManager.gameEnd,
        gameEndType = this.kGameManager.gameEndType,
        pairs = this.kLocalDataManager.pairs.map { it.toKLocalDataPairEntity() },
        money = this.kMoneyManager.money,
        newsKeys = this.kNewsManager.newsKeys,
        speedIdx = this.kTimeManager.speedIdx,
        timeScale = this.kTimeManager.timeScale,
        date = this.kTimeManager.date,
        nextNews = this.kTimeManager.nextNews,
        modificationCount = this.kTimeManager.modificationCount,
        infectDate = this.kTimeManager.infectDate,
        infectGlobalDate = this.kTimeManager.infectGlobalDate,
        kitDate = this.kTimeManager.kitDate,
        nextKitUpgradeDate = this.kTimeManager.nextKitUpgradeDate,
        nextModificationDate = this.kTimeManager.nextModificationDate,
        pcrDate = this.kTimeManager.pcrDate,
        startDate = this.kTimeManager.startDate,
        today = this.kTimeManager.today,
        vaccineEndDate = this.kTimeManager.vaccineEndDate,
        vaccineStartDate = this.kTimeManager.vaccineStartDate,
        lastMoneyMonth = this.kTimeManager.lastMoneyMonth,
        started = this.kTimeManager.started,
        globalInfected = this.kTimeManager.globalInfected,
        diseaseEnabled = this.kValueManager.diseaseEnabled,
        pcrEnabled = this.kValueManager.pcrEnabled,
        kitEnabled = this.kValueManager.kitEnabled,
        kitChance = this.kValueManager.kitChance,
        vaccineResearch = this.kValueManager.vaccineResearch,
        vaccineEnded = this.kValueManager.vaccineEnded,
        nodeIdx = this.kValueManager.nodeIdx,
        name = this.kValueManager.name,
        message = this.kValueManager.message,
        weight = this.kValueManager.weight,
        parent = this.kValueManager.parent,
        child = this.kValueManager.child,
        infectWeightGridDisease = this.kValueManager.infectWeightGridDisease,
        infectivityGridDisease = this.kValueManager.infectivityGridDisease,
        infectPowerGridDisease = this.kValueManager.infectPowerGridDisease,
        modificationDecrease = this.kValueManager.modificationDecrease,
        study = this.kValueManager.study,
        concentration = this.kValueManager.concentration,
        mask = this.kValueManager.mask,
        annoy = this.kValueManager.annoy,
        infectWeight = this.kValueManager.infectWeight,
        infectivity = this.kValueManager.infectivity,
        infectPower = this.kValueManager.infectPower,
        preInfectWeight = this.kValueManager.preInfectWeight,
        preInfectivity = this.kValueManager.preInfectivity,
        preInfectPower = this.kValueManager.preInfectPower,
        totalPerson = this.kValueManager.totalPerson,
        healthyPerson = this.kValueManager.healthyPerson,
        deathPerson = this.kValueManager.deathPerson,
        infectedPerson = this.kValueManager.infectedPerson,
        banbal = this.kValueManager.banbal,
        authority = this.kValueManager.authority,
        currentBanbal = this.kValueManager.currentBanbal,
        banbalDate = this.kValueManager.banbalDate,
        authorityDate = this.kValueManager.authorityDate,
        authorityGoodDate = this.kValueManager.authorityGoodDate,
        currentAuthority = this.kValueManager.currentAuthority,
        lastSaveDate = this.lastSaveDate
    )

    fun toKTimeLeapEntity(gameInfoEntity: GameInfoEntity) = kServerDataManager.timeLeaps.map {
        KTimeLeapEntity(
            gameInfoEntity = gameInfoEntity,
            date = it.date,
            nodeBuy = it.nodeBuy,
            nodeSell = it.nodeSell,
            money = it.money,
            authority = it.authority,
            totalPerson = it.kPerson.totalPerson,
            healthyPerson = it.kPerson.healthyPerson,
            deathPerson = it.kPerson.deathPerson,
            infectedPerson = it.kPerson.infectedPerson,
            diseaseGraph = it.diseaseGraph,
            personGraph = it.personGraph
        )
    }
}

data class KGameManager(
    val gameEnd: Boolean,
    val gameEndType: GameEndType
)

data class KLocalDataManager(
    val pairs: List<KLocalDataPair>
)

data class KLocalDataPair(
    val key: String,
    val date: String
) {
    fun toKLocalDataPairEntity() = KLocalDataPairEntity(
        pairKey = this.key,
        date = this.date
    )
}

data class KMoneyManager(
    val money: Int
)

data class KNewsManager(
    val newsKeys: List<String>
)

data class KServerDataManager(
    val timeLeaps: List<KTimeLeap>
)

data class KTimeLeap(
    val date: Int,
    val nodeBuy: List<Int>,
    val nodeSell: List<Int>,
    val money: List<Int>,
    val authority: List<Float>,
    val kPerson: KPerson,
    val diseaseGraph: List<Float>,
    val personGraph: List<Int>
)

data class KPerson(
    val totalPerson: Int,
    val healthyPerson: Int,
    val deathPerson: Int,
    val infectedPerson: Int
)

data class KTimeManager(
    val speedIdx: Int,
    val timeScale: Float,
    val date: Int,
    val nextNews: Int,
    val modificationCount: Int,

    val infectDate: String,
    val infectGlobalDate: String,
    val kitDate: String,
    val nextKitUpgradeDate: String,
    val nextModificationDate: String,
    val pcrDate: String,
    val startDate: String,
    val today: String,
    val vaccineEndDate: String,
    val vaccineStartDate: String,

    val lastMoneyMonth: Int,
    val started: Boolean,

    val globalInfected: Boolean
)

data class KValueManager(
    val diseaseEnabled: Boolean,
    val pcrEnabled: Boolean,
    val kitEnabled: Boolean,
    val kitChance: Int,
    val vaccineResearch: Boolean,
    val vaccineEnded: Boolean,

    // KValueManager 안에 LocalGridData
    val nodeIdx: Int,
    val name: String,
    val message: String,
    val weight: Float,
    val parent: List<String>,
    val child: List<String>,

    // LocalGridData 안에 GridDisease
    val infectWeightGridDisease: Float,
    val infectivityGridDisease: Float,
    val infectPowerGridDisease: Float,
    val modificationDecrease: Int,

    // LocalGridData 안에 GridAuthority
    val study: Int,
    val concentration: Int,
    val mask: Int,
    val annoy: Int,
    val infectWeight: Float,
    val infectivity: Int,
    val infectPower: Float,
    val preInfectWeight: Float,
    val preInfectivity: Int,
    val preInfectPower: Float,
    val totalPerson: Int,
    val healthyPerson: Int,
    val deathPerson: Int,
    val infectedPerson: Int,
    val banbal: Float,
    val authority: Float,
    val currentBanbal: Int,
    val banbalDate: Int,
    val authorityDate: Int,
    val authorityGoodDate: Int,
    val currentAuthority: Float
)
