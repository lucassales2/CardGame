package lucassales.com.data.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import lucassales.com.data.entities.Card

@Dao
abstract class CardDao : EntityDao<Card> {

    @Query("SELECT * FROM cards")
    abstract fun all(): Flowable<Card>
}