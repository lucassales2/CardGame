package lucassales.com.core

import lucassales.com.data.entities.Figure
import lucassales.com.data.entities.Suit

interface Rules {
    val validFigures: Array<Figure>
    val validSuits: Array<Suit>
}