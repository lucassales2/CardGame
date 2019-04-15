package lucassales.com.data

import androidx.room.Database
import androidx.room.RoomDatabase
import lucassales.com.data.dao.CardDao
import lucassales.com.data.dao.FigureDao
import lucassales.com.data.dao.SuitDao
import lucassales.com.data.entities.Card
import lucassales.com.data.entities.Figure
import lucassales.com.data.entities.Suit

@Database(
    entities = [
        Card::class,
        Figure::class,
        Suit::class
    ], version = 1
)
abstract class GameDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
    abstract fun figureDao(): FigureDao
    abstract fun suitDao(): SuitDao
}