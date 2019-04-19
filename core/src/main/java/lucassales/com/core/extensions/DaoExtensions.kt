package lucassales.com.core.extensions

import lucassales.com.core.solitaire.model.DeckPile
import lucassales.com.core.solitaire.model.FoundationPile
import lucassales.com.core.solitaire.model.FoundationPiles
import lucassales.com.core.solitaire.model.TableauPile
import lucassales.com.core.solitaire.model.TableauPiles
import lucassales.com.core.solitaire.model.WastePile
import lucassales.com.data.dao.pile.PileDao
import lucassales.com.data.entities.pile.PileType

suspend fun PileDao.wastePile(matchId: Long): WastePile {
    val first = getByMatchIdAndType(matchId, PileType.Waste).first()
    return WastePile(first.cards, first.pile.id)
}

suspend fun PileDao.deckPile(matchId: Long): DeckPile {
    val pileWithCards = getByMatchIdAndType(matchId, PileType.Deck).first()
    return DeckPile(pileWithCards.cards, pileWithCards.pile.id)
}

suspend fun PileDao.tableauPiles(matchId: Long): TableauPiles {
    return TableauPiles(getByMatchIdAndType(matchId, PileType.Tableau).map {
        TableauPile(it.cards, it.pile.id)
    })
}

suspend fun PileDao.foundationPiles(matchId: Long): FoundationPiles {
    return FoundationPiles(getByMatchIdAndType(matchId, PileType.Foundation).map {
        FoundationPile(it.cards, it.pile.id)
    })
}