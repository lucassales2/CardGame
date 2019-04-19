package lucassales.com.domain.create

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.data.dao.pile.NewPileDao
import lucassales.com.data.entities.pile.Pile
import lucassales.com.data.entities.pile.PileType
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.ResultInteractor

class CreatePileInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val pileDao: NewPileDao
) : ResultInteractor<CreatePileInteractor.Input, Long> {

    data class Input(val matchId: Long, val pileType: PileType)

    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Input): Long {
        return pileDao.insert(
            Pile(
                matchId = input.matchId,
                type = input.pileType
            )
        )
    }
}