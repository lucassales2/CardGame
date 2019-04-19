package lucassales.com.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Flowable
import lucassales.com.data.entities.Match
import lucassales.com.data.entities.relation.Solitaire

@Dao
abstract class MatchDao : EntityDao<Match> {

    @Transaction
    @Query("SELECT * FROM matches WHERE id =:id")
    abstract fun getMatchById(id: Long): Flowable<Solitaire>

    @Transaction
    @Query("SELECT * FROM matches WHERE id =:id")
    abstract suspend fun getMatchByIdSuspend(id: Long): Solitaire?
}