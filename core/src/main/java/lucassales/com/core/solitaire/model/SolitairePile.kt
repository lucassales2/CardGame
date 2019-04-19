package lucassales.com.core.solitaire.model

import lucassales.com.data.entities.SolitaireCard
import lucassales.com.data.entities.pile.PileType

sealed class SolitairePile(val id: Long, pileType: PileType) {
    abstract fun canAddCard(card: SolitaireCard): Boolean
}

class WastePile(val cards: List<SolitaireCard>, id: Long) : SolitairePile(id, PileType.Waste) {
    override fun canAddCard(card: SolitaireCard): Boolean {

    }
}

class DeckPile(val cards: List<SolitaireCard>, id: Long) : SolitairePile(id, PileType.Deck) {
    override fun canAddCard(card: SolitaireCard): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class FoundationPile(val cards: List<SolitaireCard>, id: Long) :
    SolitairePile(id, PileType.Foundation) {
    override fun canAddCard(card: SolitaireCard): Boolean {

    }
}

class TableauPile(val cards: List<SolitaireCard>, id: Long) : SolitairePile(id, PileType.Tableau) {
    override fun canAddCard(card: SolitaireCard): Boolean {
        
    }
}

data class TableauPiles(val piles: List<TableauPile>)

data class FoundationPiles(val piles: List<FoundationPile>)
