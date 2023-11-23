package team.sfe.server.domain.progress.domain

import com.querydsl.core.group.GroupBy.groupBy
import com.querydsl.core.group.GroupBy.list
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import team.sfe.server.domain.progress.domain.QGameInfoEntity.gameInfoEntity
import team.sfe.server.domain.progress.domain.QPersonDataEntity.personDataEntity
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
            .join(gameInfoEntity.userEntity, userEntity)
            .on(gameInfoEntity.userEntity.id.eq(userId))
            .join(personDataEntity.userEntity, userEntity)
            .on(personDataEntity.userEntity.id.eq(userId))
            .where(userEntity.id.eq(userId))
            .transform(
                groupBy(userEntity.id).list(
                    QQueryProgressVO(
                        gameInfoEntity,
                        list(personDataEntity)
                    )
                )
            )[0]
    }
}
