package team.sfe.server.domain.progress.domain

import com.querydsl.core.group.GroupBy.groupBy
import com.querydsl.core.group.GroupBy.list
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import team.sfe.server.domain.progress.domain.QDiseaseEntity.diseaseEntity
import team.sfe.server.domain.progress.domain.QGameInfoEntity.gameInfoEntity
import team.sfe.server.domain.progress.domain.QPersonDataEntity.personDataEntity
import team.sfe.server.domain.progress.domain.QPersonEntity.personEntity
import team.sfe.server.domain.progress.domain.vo.QQueryProgressVO
import team.sfe.server.domain.progress.domain.vo.QueryProgressVO
import team.sfe.server.domain.user.domain.QUserEntity.userEntity

@Repository
class ProgressRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {

    fun queryProgress(userId: Long): QueryProgressVO? {
        return jpaQueryFactory
            .selectFrom(userEntity)
            .join(diseaseEntity.userEntity, userEntity)
            .join(gameInfoEntity.userEntity, userEntity)
            .join(personDataEntity.userEntity, userEntity)
            .join(personEntity.userEntity, userEntity)
            .where(userEntity.id.eq(userId))
            .transform(
                groupBy(userEntity.id).list(
                    QQueryProgressVO(
                        diseaseEntity,
                        gameInfoEntity,
                        list(personDataEntity),
                        personEntity
                    )
                )
            )[0]
    }
}
