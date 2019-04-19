package lucassales.com.data.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import lucassales.com.data.entities.Card

@Dao
abstract class CardDao : EntityDao<Card> {

    @Query("SELECT * FROM cards")
    abstract fun all(): Flowable<List<Card>>

    @Query("SELECT * FROM cards")
    abstract suspend fun allSuspend(): List<Card>

    @Query("SELECT id FROM cards")
    abstract suspend fun allIds(): List<Long>

    @Query("SELECT * FROM cards where id =:cardId")
    abstract fun getById(cardId: Long): Card
}