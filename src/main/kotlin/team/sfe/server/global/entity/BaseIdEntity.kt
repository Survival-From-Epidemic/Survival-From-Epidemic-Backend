package team.sfe.server.global.entity

import jakarta.persistence.*
import java.math.BigInteger

@MappedSuperclass
abstract class BaseIDEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: BigInteger

)
