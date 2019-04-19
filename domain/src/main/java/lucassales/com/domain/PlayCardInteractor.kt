package lucassales.com.domain

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.dao.pile.NewPileDao
import lucassales.com.data.entities.pile.PileType

class PlayCardInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val pileDao: NewPileDao,
    private val solitaireCardDao: SolitaireCardDao
) : Interactor<PlayCardInteractor.Input> {

    data class Input(val matchId: Long, val cardId: Long)

    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Input) {

        val card = solitaireCardDao.getById(input.cardId)
        val foundationPiles = pileDao.getByMatchIdAndType(input.matchId, PileType.Foundation)
        val tableauPiles = pileDao.getByMatchIdAndType(input.matchId, PileType.Tableau)
        foundationPiles.forEach {
            //            if (it.canAddCard(card)) {
//                solitaireCardDao.update(card.copy(pileId = it.pile.id))
//                return
//            }
        }

        tableauPiles.forEach {
            //            if (it.canAddCards(listOf(card))) {
//                solitaireCardDao.update(card.copy(pileId = it.pile.id))
//                return
//            }
        }
    }
}