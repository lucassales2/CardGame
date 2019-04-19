package lucassales.com.data.converter

import androidx.room.TypeConverter
import lucassales.com.data.entities.pile.PileType

class DataConverter {
    @TypeConverter
    fun fromLongList(value: List<Long>): String {
        return value.joinToString { "$it" }
    }

    @TypeConverter
    fun toLongList(value: String): List<Long> {
        return value.split(',').map { it.trim().toLong() }
    }

    @TypeConverter
    fun fromPileType(value: PileType): Int {
        return value.ordinal
    }

    @TypeConverter
    fun toPileType(value: Int): PileType {
        return when (value) {
            PileType.Foundation.ordinal -> PileType.Foundation
            PileType.Tableau.ordinal -> PileType.Tableau
            PileType.Deck.ordinal -> PileType.Deck
            PileType.Waste.ordinal -> PileType.Waste
            else -> PileType.Unknown
        }
    }
}