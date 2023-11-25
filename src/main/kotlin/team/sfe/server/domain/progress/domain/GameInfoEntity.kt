package team.sfe.server.domain.progress.domain

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.ElementCollection
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.progress.domain.type.GameEndType
import team.sfe.server.domain.progress.presentation.dto.KGameManager
import team.sfe.server.domain.progress.presentation.dto.KLocalDataManager
import team.sfe.server.domain.progress.presentation.dto.KLocalDataPair
import team.sfe.server.domain.progress.presentation.dto.KTimeManager
import team.sfe.server.domain.progress.presentation.dto.KValueManager
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.global.converter.StringListToStringConverter
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class GameInfoEntity(
    id: Long = 0L,

    @field:NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    // KValueManager
    diseaseEnabled: Boolean,

    pcrEnabled: Boolean,

    kitEnabled: Boolean,

    kitChance: Int,

    vaccineResearch: Boolean,

    vaccineEnded: Boolean,

    // KValueManager 안에 LocalGridData
    nodeIdx: Int,

    name: String,

    message: String,

    weight: Float,

    parent: List<String>,

    child: List<String>,

    // LocalGridData 안에 GridDisease
    infectWeightGridDisease: Float,

    infectivityGridDisease: Float,

    infectPowerGridDisease: Float,

    modificationDecrease: Int,

    // LocalGridData 안에 GridAuthority
    study: Int,

    concentration: Int,

    mask: Int,

    annoy: Int,

    infectWeight: Float,

    infectivity: Int,

    infectPower: Float,

    preInfectWeight: Float,

    preInfectivity: Int,

    preInfectPower: Float,

    totalPerson: Int,

    healthyPerson: Int,

    deathPerson: Int,

    infectedPerson: Int,

    banbal: Float,

    authority: Float,

    currentBanbal: Int,

    banbalDate: Int,

    authorityDate: Int,

    authorityGoodDate: Int,

    currentAuthority: Float,
    // ---------------------------------

    // KGameManager
    gameEnd: Boolean,

    gameEndType: GameEndType,
    // ---------------------------------

    // KLocalDataManager
    @ElementCollection
    @CollectionTable(
        name = "KLocalDataPairEntity",
        joinColumns = [JoinColumn(name = "gameInfoId")]
    )
    val pairs: List<KLocalDataPairEntity>,
    // ---------------------------------

    // KMoneyManager
    money: Int,
    // ---------------------------------

    // KNewsManager
    newsKeys: List<String>,
    // ---------------------------------

    // KTimeManager
    speedIdx: Int,

    timeScale: Float,

    date: Int,

    nextNews: Int,

    modificationCount: Int,

    infectDate: String,

    infectGlobalDate: String,

    kitDate: String,

    nextKitUpgradeDate: String,

    nextModificationDate: String,

    pcrDate: String,

    startDate: String,

    today: String,

    vaccineEndDate: String,

    vaccineStartDate: String,

    lastMoneyMonth: Int,

    started: Boolean,

    globalInfected: Boolean,
    // ---------------------------------

    lastSaveDate: String,
) : BaseIdEntity(id) {

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var diseaseEnabled = diseaseEnabled
        protected set

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var pcrEnabled = pcrEnabled
        protected set

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var kitEnabled = kitEnabled
        protected set

    @field:NotNull
    @Column(columnDefinition = "INT")
    var kitChance = kitChance
        protected set

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var vaccineResearch = vaccineResearch
        protected set

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var vaccineEnded = vaccineEnded
        protected set

    @field:NotNull
    var nodeIdx = nodeIdx
        protected set

    @field:NotNull
    var name = name
        protected set

    @field:NotNull
    var message = message
        protected set

    @field:NotNull
    var weight = weight
        protected set

    @field:NotNull
    @Convert(converter = StringListToStringConverter::class)
    var parent = parent
        protected set

    @field:NotNull
    @Convert(converter = StringListToStringConverter::class)
    var child = child
        protected set

    @field:NotNull
    var infectWeightGridDisease = infectWeightGridDisease
        protected set

    @field:NotNull
    var infectivityGridDisease = infectivityGridDisease
        protected set

    @field:NotNull
    var infectPowerGridDisease = infectPowerGridDisease
        protected set

    @field:NotNull
    var modificationDecrease = modificationDecrease
        protected set

    @field:NotNull
    var study = study
        protected set

    @field:NotNull
    var concentration = concentration
        protected set

    @field:NotNull
    var mask = mask
        protected set

    @field:NotNull
    var annoy = annoy
        protected set

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    var infectWeight = infectWeight
        protected set

    @field:NotNull
    @Column(columnDefinition = "INT")
    var infectivity = infectivity
        protected set

    @field:NotNull
    @Column(columnDefinition = "FLOAT")
    var infectPower = infectPower
        protected set

    @field:NotNull
    @Column(columnDefinition = "TINYINT(1)")
    var gameEnd = gameEnd
        protected set

    @field:NotNull
    @Enumerated(EnumType.STRING)
    var gameEndType = gameEndType
        protected set

    @field:NotNull
    @Column(columnDefinition = "INT")
    var money = money
        protected set

    @field:NotNull
    @Convert(converter = StringListToStringConverter::class)
    var newsKeys = newsKeys
        protected set

    @field:NotNull
    var speedIdx = speedIdx
        protected set

    @field:NotNull
    var timeScale = timeScale
        protected set

    @field:NotNull
    var date = date
        protected set

    @field:NotNull
    var nextNews = nextNews
        protected set

    @field:NotNull
    var modificationCount = modificationCount
        protected set

    @field:NotNull
    var infectDate = infectDate
        protected set

    @field:NotNull
    var infectGlobalDate = infectGlobalDate
        protected set

    @field:NotNull
    var kitDate = kitDate
        protected set

    @field:NotNull
    var nextKitUpgradeDate = nextKitUpgradeDate
        protected set

    @field:NotNull
    var nextModificationDate = nextModificationDate
        protected set

    @field:NotNull
    var pcrDate = pcrDate
        protected set

    @field:NotNull
    var startDate = startDate
        protected set

    @field:NotNull
    var today = today
        protected set

    @field:NotNull
    var vaccineEndDate = vaccineEndDate
        protected set

    @field:NotNull
    var vaccineStartDate = vaccineStartDate
        protected set

    @field:NotNull
    var lastMoneyMonth = lastMoneyMonth
        protected set

    @field:NotNull
    var started = started
        protected set

    @field:NotNull
    var globalInfected = globalInfected
        protected set

    @field:NotNull
    var totalPerson = totalPerson
        protected set

    @field:NotNull
    var healthyPerson = healthyPerson
        protected set

    @field:NotNull
    var deathPerson = deathPerson
        protected set

    @field:NotNull
    var infectedPerson = infectedPerson
        protected set

    @field:NotNull
    var preInfectWeight = preInfectWeight
        protected set

    @field:NotNull
    var preInfectivity = preInfectivity
        protected set

    @field:NotNull
    var preInfectPower = preInfectPower
        protected set

    @field:NotNull
    var banbal = banbal
        protected set

    @field:NotNull
    var authority = authority
        protected set

    @field:NotNull
    var currentBanbal = currentBanbal
        protected set

    @field:NotNull
    var banbalDate = banbalDate
        protected set

    @field:NotNull
    var authorityDate = authorityDate
        protected set

    @field:NotNull
    var authorityGoodDate = authorityGoodDate
        protected set

    @field:NotNull
    var currentAuthority = currentAuthority
        protected set

    @field:NotNull
    var lastSaveDate = lastSaveDate
        protected set

    fun updateGameInfo(
        diseaseEnabled: Boolean,
        pcrEnabled: Boolean,
        kitEnabled: Boolean,
        kitChance: Int,
        vaccineResearch: Boolean,
        vaccineEnded: Boolean,
        infectWeight: Float,
        infectivity: Int,
        infectPower: Float,
        totalPerson: Int,
        healthyPerson: Int,
        deathPerson: Int,
        infectedPerson: Int,
    ) {
        this.diseaseEnabled = diseaseEnabled
        this.pcrEnabled = pcrEnabled
        this.kitEnabled = kitEnabled
        this.kitChance = kitChance
        this.vaccineResearch = vaccineResearch
        this.vaccineEnded = vaccineEnded
        this.infectWeight = infectWeight
        this.infectivity = infectivity
        this.infectPower = infectPower
        this.totalPerson = totalPerson
        this.healthyPerson = healthyPerson
        this.deathPerson = deathPerson
        this.infectedPerson = infectedPerson
    }

    fun toKGameManager() = KGameManager(
        gameEnd = this.gameEnd,
        gameEndType = this.gameEndType,
    )

    fun toKLocalDataManager() = KLocalDataManager(
        pairs = this.pairs.map {
            KLocalDataPair(
                key = it.pairKey,
                date = it.date,
            )
        }
    )

    fun toKTimeManager() = KTimeManager(
        speedIdx, timeScale, date, nextNews, modificationCount,
        infectDate, infectGlobalDate, kitDate, nextKitUpgradeDate, nextModificationDate,
        pcrDate, startDate, today, vaccineEndDate, vaccineStartDate,
        lastMoneyMonth, started, globalInfected
    )

    fun toKValueManager() = KValueManager(
        diseaseEnabled, pcrEnabled, kitEnabled, kitChance, vaccineResearch,
        vaccineEnded, nodeIdx, name, message, weight,
        parent, child, infectWeightGridDisease, infectivityGridDisease, infectPowerGridDisease,
        modificationDecrease, study, concentration, mask, annoy,
        infectWeight, infectivity, infectPower, preInfectWeight, preInfectivity,
        preInfectPower, totalPerson, healthyPerson, deathPerson, infectedPerson,
        banbal, authority, currentBanbal, banbalDate, authorityDate,
        authorityGoodDate, currentAuthority
    )
}

@Embeddable
data class KLocalDataPairEntity(
    val pairKey: String,
    val date: String,
)
