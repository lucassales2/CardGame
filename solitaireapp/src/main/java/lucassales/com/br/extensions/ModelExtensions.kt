package lucassales.com.br.extensions

import lucassales.com.br.R
import lucassales.com.core.solitaire.isDeckEmpty
import lucassales.com.core.solitaire.wasteCard
import lucassales.com.data.entities.SolitaireCard
import lucassales.com.data.entities.relation.Solitaire

val SolitaireCard.drawable: Int
    get() {
        return if (!faceUp) {
            R.drawable.backface_blu
        } else when (cardId) {
            1L -> R.drawable.card1diamonds
            2L -> R.drawable.card2diamonds
            3L -> R.drawable.card3diamonds
            4L -> R.drawable.card4diamonds
            5L -> R.drawable.card5diamonds
            6L -> R.drawable.card6diamonds
            7L -> R.drawable.card7diamonds
            8L -> R.drawable.card8diamonds
            9L -> R.drawable.card9diamonds
            10L -> R.drawable.card10diamonds
            11L -> R.drawable.card11diamonds
            12L -> R.drawable.card12diamonds
            13L -> R.drawable.card13diamonds
            14L -> R.drawable.card1spades
            15L -> R.drawable.card2spades
            16L -> R.drawable.card3spades
            17L -> R.drawable.card4spades
            18L -> R.drawable.card5spades
            19L -> R.drawable.card6spades
            20L -> R.drawable.card7spades
            21L -> R.drawable.card8spades
            22L -> R.drawable.card9spades
            23L -> R.drawable.card10spades
            24L -> R.drawable.card11spades
            25L -> R.drawable.card12spades
            26L -> R.drawable.card13spades
            27L -> R.drawable.card1hearts
            28L -> R.drawable.card2hearts
            29L -> R.drawable.card3hearts
            30L -> R.drawable.card4hearts
            31L -> R.drawable.card5hearts
            32L -> R.drawable.card6hearts
            33L -> R.drawable.card7hearts
            34L -> R.drawable.card8hearts
            35L -> R.drawable.card9hearts
            36L -> R.drawable.card10hearts
            37L -> R.drawable.card11hearts
            38L -> R.drawable.card12hearts
            39L -> R.drawable.card13hearts
            40L -> R.drawable.card1clubs
            41L -> R.drawable.card2clubs
            42L -> R.drawable.card3clubs
            43L -> R.drawable.card4clubs
            44L -> R.drawable.card5clubs
            45L -> R.drawable.card6clubs
            46L -> R.drawable.card7clubs
            47L -> R.drawable.card8clubs
            48L -> R.drawable.card9clubs
            49L -> R.drawable.card10clubs
            50L -> R.drawable.card11clubs
            51L -> R.drawable.card12clubs
            52L -> R.drawable.card13clubs
            else -> R.drawable.empty_card
        }
    }

val Solitaire.wasteDrawable
    get() = wasteCard?.drawable
        ?: R.drawable.empty_card

val Solitaire.deckDrawable: Int
    get() = if (isDeckEmpty) {
        R.drawable.empty_card
    } else {
        R.drawable.backface_blu
    }
