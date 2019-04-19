package lucassales.com.domain.solitaire

import io.reactivex.Flowable
import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.data.dao.MatchDao
import lucassales.com.data.entities.relation.Solitaire
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.SubjectInteractor

class GetMatchByIdInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val matchDao: MatchDao
) : SubjectInteractor<Long, Unit, Solitaire>() {
    override suspend fun execute(params: Long, executeParams: Unit) {
    }

    override fun createObservable(params: Long): Flowable<Solitaire> {
        return matchDao.getMatchById(params)
    }

    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io
}