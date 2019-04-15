package lucassales.com.data.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import lucassales.com.data.entities.Suit

@Dao
abstract class SuitDao : EntityDao<Suit> {

    @Query("SELECT * FROM suits")
    abstract fun all(): Flowable<Suit>
}