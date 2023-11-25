package team.sfe.server.domain.progress.domain

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull
import team.sfe.server.global.converter.FloatListToStringConverter
import team.sfe.server.global.converter.IntListToStringConverter
import team.sfe.server.global.entity.BaseIdEntity

@Entity
class KTimeLeapEntity(
    id: Long = 0L,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_info_id")
    val gameInfoEntity: GameInfoEntity,

    @field:NotNull
    val date: Int,

    @field:NotNull
    @Convert(converter = IntListToStringConverter::class)
    val nodeBuy: List<Int>,

    @field:NotNull
    @Convert(converter = IntListToStringConverter::class)
    val nodeSell: List<Int>,

    @field:NotNull
    @Convert(converter = IntListToStringConverter::class)
    val money: List<Int>,

    @field:NotNull
    @Convert(converter = FloatListToStringConverter::class)
    val authority: List<Float>,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val totalPerson: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val healthyPerson: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val deathPerson: Int,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val infectedPerson: Int,

    @field:NotNull
    @Convert(converter = FloatListToStringConverter::class)
    val diseaseGraph: List<Float>,

    @field:NotNull
    @Convert(converter = IntListToStringConverter::class)
    val personGraph: List<Int>
) : BaseIdEntity(id)
