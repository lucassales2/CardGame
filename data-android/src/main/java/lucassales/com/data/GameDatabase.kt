package lucassales.com.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import lucassales.com.data.converter.DataConverter
import lucassales.com.data.dao.CardDao
import lucassales.com.data.dao.FigureDao
import lucassales.com.data.dao.MatchDao
import lucassales.com.data.dao.SolitaireCardDao
import lucassales.com.data.dao.SuitDao
import lucassales.com.data.dao.pile.PileDao
import lucassales.com.data.entities.Card
import lucassales.com.data.entities.Figure
import lucassales.com.data.entities.Match
import lucassales.com.data.entities.SolitaireCard
import lucassales.com.data.entities.Suit
import lucassales.com.data.entities.pile.Pile

@Database(
    entities = [
        Card::class,
        Figure::class,
        Suit::class,
        Match::class,
        Pile::class,
        SolitaireCard::class

    ], version = 1
)
@TypeConverters(DataConverter::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun figureDao(): FigureDao
    abstract fun suitDao(): SuitDao
    abstract fun matchDao(): MatchDao
    abstract fun pileDao(): PileDao
    abstract fun solitaireCardDao(): SolitaireCardDao
}