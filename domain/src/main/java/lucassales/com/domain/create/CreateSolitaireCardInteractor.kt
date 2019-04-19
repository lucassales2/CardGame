package lucassales.com.domain.create

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.entities.SolitaireCard
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.ResultInteractor

class CreateSolitaireCardInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val solitaireCardDao: SolitaireCardDao
) : ResultInteractor<CreateSolitaireCardInteractor.Input, Long> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Input): Long {
        return solitaireCardDao.insert(
            SolitaireCard(
                cardId = input.cardId,
                pileId = input.pileId,
                faceUp = input.faceUp
            )
        )
    }

    data class Input(val cardId: Long, val pileId: Long, val faceUp: Boolean = false)
}