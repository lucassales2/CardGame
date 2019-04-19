package lucassales.com.core.extensions

import lucassales.com.data.entities.SolitaireCard
import lucassales.com.data.entities.pile.PileType
import lucassales.com.data.entities.relation.Solitaire

val Solitaire.wasteCard: SolitaireCard?
    get() = piles.find { it.pile.type == PileType.Waste }?.cards?.firstOrNull()

val Solitaire.isDeckEmpty: Boolean
    get() = piles.find { it.pile.type == PileType.Deck }?.cards?.isEmpty() ?: false