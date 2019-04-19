package lucassales.com.data.entities.pile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import lucassales.com.data.entities.Match

@Entity(
    tableName = "tableau_pile",
    foreignKeys = [
        ForeignKey(
            entity = Match::class,
            childColumns = ["match_id"],
            parentColumns = ["id"]
        )
    ]
)
data class TableauPile(
    override val id: Long,
    @ColumnInfo(name = "match_id", index = true) override val matchId: Long,
    val row: Int,
    override val type: PileType = PileType.Tableau
) : PileEntity