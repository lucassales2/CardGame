package lucassales.com.domain.actions

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.dao.pile.NewPileDao
import lucassales.com.data.entities.pile.PileType
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.Interactor

class TapDeckInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val pileDao: NewPileDao,
    private val solitaireCardDao: SolitaireCardDao
) :
    Interactor<TapDeckInteractor.Input> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Input) {
        val deck = pileDao.getByMatchIdAndType(input.matchId, PileType.Deck).first()
        val waste = pileDao.getByMatchIdAndType(input.matchId, PileType.Waste).first()
        when {
            deck.cards.isEmpty() && waste.cards.isEmpty() -> {
                // Do nothing
            }
            deck.cards.isEmpty() -> {
                solitaireCardDao.updateAll(waste.cards.onEach {
                    it.faceUp = false
                    it.pileId = deck.pile.id
                })
            }
            else -> {
                solitaireCardDao.update(deck.cards.last().apply {
                    faceUp = true
                    pileId = waste.pile.id
                })
            }
        }
    }

    data class Input(val matchId: Long)
}