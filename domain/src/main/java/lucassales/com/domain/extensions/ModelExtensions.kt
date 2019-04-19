package lucassales.com.domain.extensions

// fun FoundationPile.canAddCard(cardToAdd: SolitaireCard): Boolean {
//    if (cardToAdd.pileId == pile.id) return false
//    val lastCard = cards.lastOrNull() ?: return false
//    return cardToAdd.card.suitId == suitId && cardToAdd.value == lastCard.value + 1
// }
//
// fun TableauPile.canAddCards(cardsToAdd: List<SolitaireCard>): Boolean {
//    if (cardsToAdd.any { it.pileId == pile.id }) return false
//    if (cards.isNotEmpty()) {
//        if (cardsToAdd.first().value == cards.last().value - 1 &&
//            suitCheck(cardsToAdd.first(), cards.last())
//        ) return true
//    } else if (cardsToAdd.first().value == 12) return true
//    return false
// }
//
// fun suitCheck(first: SolitaireCard, last: SolitaireCard): Boolean {
//    return first.card.suitId % 2 != last.card.suitId % 2
// }
