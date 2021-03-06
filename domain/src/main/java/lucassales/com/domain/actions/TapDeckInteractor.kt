package lucassales.com.domain.actions

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.core.extensions.deckPile
import lucassales.com.core.extensions.wastePile
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.dao.pile.PileDao
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.Interactor

class TapDeckInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val pileDao: PileDao,
    private val solitaireCardDao: SolitaireCardDao
) :
    Interactor<Long> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Long) {
        val deck = pileDao.deckPile(input)
        val waste = pileDao.wastePile(input)
        when {
            deck.cards.isEmpty() && waste.cards.isEmpty() -> {
                // Do nothing
            }
            deck.cards.isEmpty() -> {
                solitaireCardDao.updateAll(waste.cards.map {
                    it.copy(
                        faceUp = false,
                        pileId = deck.id
                    )
                })
            }
            else -> {
                solitaireCardDao.update(
                    deck.cards.last().copy(
                        faceUp = true,
                        pileId = waste.id
                    )
                )
            }
        }
    }
}