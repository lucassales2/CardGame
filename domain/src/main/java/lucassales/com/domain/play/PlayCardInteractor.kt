package lucassales.com.domain.play

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.core.extensions.foundationPiles
import lucassales.com.core.extensions.tableauPiles
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.dao.pile.PileDao
import lucassales.com.data.entities.pile.PileType
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.Interactor
import lucassales.com.domain.ResultInteractor

class PlayCardInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val pileDao: PileDao,
    private val solitaireCardDao: SolitaireCardDao
) : ResultInteractor<PlayCardInteractor.Input, Boolean> {

    data class Input(val matchId: Long, val cardId: Long)

    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Input): Boolean {

        val card = solitaireCardDao.getById(input.cardId)
        val foundationPiles = pileDao.foundationPiles(input.matchId)
        foundationPiles.piles.forEach {
                        if (it.canAddCard(card)) {
                solitaireCardDao.update(card.copy(pileId = it.pile.id))
                return
            }
        }
        val tableauPiles = pileDao.tableauPiles(input.matchId)

        tableauPiles.piles.forEach {
            //            if (it.canAddCards(listOf(card))) {
//                solitaireCardDao.update(card.copy(pileId = it.pile.id))
//                return
//            }
        }
    }
}