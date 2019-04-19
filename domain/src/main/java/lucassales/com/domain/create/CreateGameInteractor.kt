package lucassales.com.domain.create

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.core.Rules
import lucassales.com.data.dao.CardDao
import lucassales.com.data.dao.MatchDao
import lucassales.com.data.entities.Match
import lucassales.com.data.entities.pile.PileType
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.GenerateEntitiesInteractor
import lucassales.com.domain.ResultInteractor

class CreateGameInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val generateEntitiesInteractor: GenerateEntitiesInteractor,
    private val createPileInteractor: CreatePileInteractor,
    private val createSolitaireCardInteractor: CreateSolitaireCardInteractor,
    private val cardDao: CardDao,
    private val matchDao: MatchDao
) : ResultInteractor<Rules, Long> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Rules): Long {
        generateEntitiesInteractor(input)

        val cards = cardDao.allIds().toMutableList().apply { shuffle() }
        val match = Match(originalCards = cards)
        val matchId = matchDao.insert(match)

        for (i in 0 until input.validSuits.size) {
            createPileInteractor(CreatePileInteractor.Input(matchId, PileType.Foundation))
        }

        for (i in 0 until 7) {
            val pileId = createPileInteractor(CreatePileInteractor.Input(matchId, PileType.Tableau))
            for (j in 0 until i + 1) {
                val cardToAdd = cards.removeAt(0)
                createSolitaireCardInteractor(
                    CreateSolitaireCardInteractor.Input(
                        cardId = cardToAdd,
                        pileId = pileId,
                        faceUp = j == i
                    )
                )
            }
        }

        val deckPileId = createPileInteractor(CreatePileInteractor.Input(matchId, PileType.Deck))
        while (cards.isNotEmpty()) {
            val cardToAdd = cards.removeAt(0)
            createSolitaireCardInteractor(
                CreateSolitaireCardInteractor.Input(
                    cardId = cardToAdd,
                    pileId = deckPileId
                )
            )
        }

        createPileInteractor(CreatePileInteractor.Input(matchId, PileType.Waste))
        return matchId
    }
}