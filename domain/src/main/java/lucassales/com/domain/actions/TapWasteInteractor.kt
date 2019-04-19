package lucassales.com.domain.actions

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.core.extensions.foundationPiles
import lucassales.com.core.extensions.wastePile
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.dao.pile.PileDao
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.Interactor

class TapWasteInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val pileDao: PileDao
) : Interactor<Long> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Long) {
        val wastePile = pileDao.wastePile(input)
        wastePile.cards.last().cardId
        val foundationPiles = pileDao.foundationPiles(input)
    }
}