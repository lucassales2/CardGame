// package lucassales.com.core
//
// import lucassales.com.data.entities.NoCard
// import lucassales.com.data.entities.SolitaireCard
// import lucassales.com.data.entities.Suit
//
// class Solitaire(val deck: Deck) {
//
//    val wastePile = mutableListOf<SolitaireCard>()
//    val foundationPiles = Array(4) {
//        FoundationPile(TODO())
//    }
//
//    val tableauPiles: Array<TableauPile> = Array(7) { TableauPile() }
//
//    fun reset() {
//
//        foundationPiles.forEach { it.reset() }
//
//        deck.reset()
//
//        tableauPiles.forEachIndexed { i, _ ->
//            val cardsInPile: MutableList<SolitaireCard> =
//                Array(i + 1) { deck.drawCard() }.toMutableList()
//
//            tableauPiles[i] = TableauPile(cardsInPile)
//        }
//    }
//
//    fun tapDeck() {
//            val card = deck.drawCard()
//        if (card != NoCard) {
//            card.faceUp = true
//            wastePile.add(card)
//        } else {
//            deck.addWaste(wastePile)
//            wastePile.clear()
//        }
//    }
//
//    fun tapWaste(): Boolean {
//        wastePile.lastOrNull()?.let { card ->
//            if (playCard(card)) {
//                wastePile.remove(card)
//                return true
//            }
//        }
//        return false
//    }
//
//    fun tapFoundation(foundationPile: FoundationPile) {
//
//        if (foundationPile.cards.isNotEmpty()) {
//            val card = foundationPile.cards.last()
//
//            if (playCard(card))
//                foundationPile.removeCard(card)
//        }
//    }
//
//    fun tapTableau(tableauPile: TableauPile, cardIndex: Int = -1): Boolean {
//        val index = if (cardIndex == -1) tableauPile.cards.lastIndex else cardIndex
//        if (tableauPile.cards.isNotEmpty()) {
//            val cards = tableauPile.cards.subList(index, tableauPile.cards.lastIndex + 1)
//
//            if (playCards(cards)) {
//                tableauPile.removeCards(index)
//                return true
//            }
//        }
//        return false
//    }
//
//    fun tapTableau(index: Int, cardIndex: Int): Boolean {
//        return tapTableau(tableauPile = tableauPiles[index], cardIndex = cardIndex)
//    }
//
//    private fun playCard(card: SolitaireCard): Boolean {
//        foundationPiles.forEach {
//            if (it.addCard(card))
//                return true
//        }
//
//        tableauPiles.forEach {
//            if (it.addCards(listOf(card)))
//                return true
//        }
//
//        return false
//    }
//
//    private fun playCards(cards: MutableList<SolitaireCard>): Boolean {
//        if (cards.size == 1)
//            return playCard(cards.first())
//        else {
//            tableauPiles.forEach {
//                if (it.addCards(cards))
//                    return true
//            }
//        }
//
//        return false
//    }
//
//    fun debugPrint() {
//        print(bodyString())
//    }
//
//    private fun bodyString(): String {
//        var body = ""
//        var firstLine = ""
//        firstLine += wastePile.lastOrNull()?.toString() ?: "___"
//        firstLine = firstLine.padEnd(18)
//
//        foundationPiles.forEach {
//            firstLine += it.cards.lastOrNull()?.toString() ?: "___"
//            firstLine += "   "
//        }
//        body += "\n$firstLine\n"
//
//        for (i in 0..12) {
//            var row = ""
//            tableauPiles.forEach {
//                row += it.cards.lastOrNull()?.toString() ?: ""
//            }
//
//            body += "\n$row"
//        }
//        return body
//    }
//
//    override fun toString() = bodyString()
//
//    fun isComplete(): Boolean {
//        return foundationPiles.map { it.cards.size }.sum() == 52
//    }
// }
