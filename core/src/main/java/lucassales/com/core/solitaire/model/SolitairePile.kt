package lucassales.com.core.solitaire.model

import lucassales.com.data.entities.SolitaireCard

sealed class SolitairePile

class WastePile(val cards: List<SolitaireCard>) : SolitairePile() {

}

class DeckPile(val cards: List<SolitaireCard>) : SolitairePile() {

}

class FoundationPile(val cards: List<SolitaireCard>) : SolitairePile() {

}

class TableauPile(val cards: List<SolitaireCard>) : SolitairePile() {

}

class TableauPiles(val piles: List<List<SolitairePile>>) : SolitairePile() {

}

class FoundationPiles(val piles: List<List<SolitairePile>>) : SolitairePile() {

}
