package lucassales.com.core.solitaire

import lucassales.com.core.Rules
import lucassales.com.data.entities.Figure
import lucassales.com.data.entities.Suit

object SolitaireRules : Rules {
    override val validFigures = arrayOf(
        Figure(1),
        Figure(2),
        Figure(3),
        Figure(4),
        Figure(5),
        Figure(6),
        Figure(7),
        Figure(8),
        Figure(9),
        Figure(10),
        Figure(11),
        Figure(12),
        Figure(13)
    )

    override val validSuits = arrayOf(
        Suit(1),
        Suit(2),
        Suit(3),
        Suit(4)
    )
}