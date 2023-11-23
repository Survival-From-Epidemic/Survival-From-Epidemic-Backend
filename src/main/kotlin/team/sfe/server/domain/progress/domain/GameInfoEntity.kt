package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.domain.progress.presentation.dto.Disease
import team.sfe.server.domain.progress.presentation.dto.Person
import team.sfe.server.domain.user.domain.UserEntity
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class GameInfoEntity(
    id: Long = 0L,

    @field:NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    diseaseEnabled: Boolean,

    pcrEnabled: Boolean,

    kitEnabled: Boolean,

    kitChance: Int,

    vaccineResearch: Boolean,

    vaccineEnded: Boolean,

    etc: String,

    infectWeight: Float,

    infectivity: Int,

    infectPower: Float,

    totalPerson: Int,

    healthyPerson: Int,

    deathPerson: Int,

    infectedPerson: Int
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
    @Column(columnDefinition = "TEXT")
    var etc = etc
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
    @Column(columnDefinition = "INT")
    var totalPerson = totalPerson
        protected set

    @field:NotNull
    @Column(columnDefinition = "INT")
    var healthyPerson = healthyPerson
        protected set

    @field:NotNull
    @Column(columnDefinition = "INT")
    var deathPerson = deathPerson
        protected set

    @field:NotNull
    @Column(columnDefinition = "INT")
    var infectedPerson = infectedPerson
        protected set

    fun updateGameInfo(
        diseaseEnabled: Boolean,
        pcrEnabled: Boolean,
        kitEnabled: Boolean,
        kitChance: Int,
        vaccineResearch: Boolean,
        vaccineEnded: Boolean,
        etc: String,
        infectWeight: Float,
        infectivity: Int,
        infectPower: Float,
        totalPerson: Int,
        healthyPerson: Int,
        deathPerson: Int,
        infectedPerson: Int
    ) {
        this.diseaseEnabled = diseaseEnabled
        this.pcrEnabled = pcrEnabled
        this.kitEnabled = kitEnabled
        this.kitChance = kitChance
        this.vaccineResearch = vaccineResearch
        this.vaccineEnded = vaccineEnded
        this.etc = etc
        this.infectWeight = infectWeight
        this.infectivity = infectivity
        this.infectPower = infectPower
        this.totalPerson = totalPerson
        this.healthyPerson = healthyPerson
        this.deathPerson = deathPerson
        this.infectedPerson = infectedPerson
    }

    fun toPersonDto() = Person(
        totalPerson = this.totalPerson,
        healthyPerson = this.healthyPerson,
        deathPerson = this.deathPerson,
        infectedPerson = this.infectedPerson
    )

    fun toDiseaseDto() = Disease(
        infectWeight = this.infectWeight,
        infectivity = this.infectivity,
        infectPower = this.infectPower
    )
}
