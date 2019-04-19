package lucassales.com.data.dao.pile

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import lucassales.com.data.dao.EntityDao
import lucassales.com.data.entities.pile.Pile
import lucassales.com.data.entities.pile.PileType
import lucassales.com.data.entities.relation.PileWithCards

@Dao
abstract class PileDao : EntityDao<Pile> {
    @Transaction
    @Query("SELECT * FROM pile WHERE type =:type and match_id =:matchId")
    abstract suspend fun getByMatchIdAndType(matchId: Long, type: PileType): List<PileWithCards>
}