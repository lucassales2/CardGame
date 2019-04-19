package lucassales.com.data.dao.pile

import androidx.room.Dao
import androidx.room.Query
import lucassales.com.data.entities.pile.TableauPile

@Dao
abstract class TableauPileDao : PileDao<TableauPile> {
    @Query("SELECT * FROM tableau_pile WHERE match_id =:matchId")
    abstract fun getByMatchId(matchId: Long): List<TableauPile>
}