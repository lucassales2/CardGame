package lucassales.com.data.dao

import androidx.room.Dao
import androidx.room.Query
import lucassales.com.data.entities.SolitaireCard

@Dao
abstract class SolitaireCardDao : EntityDao<SolitaireCard> {
    @Query("SELECT * FROM solitaire_card where id =:id")
    abstract suspend fun getById(id: Long): SolitaireCard
}