package lucassales.com.data.entities.pile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import lucassales.com.data.entities.Match

@Entity(
    tableName = "pile",
    foreignKeys = [
        ForeignKey(
            entity = Match::class,
            parentColumns = ["id"],
            childColumns = ["match_id"]
        )
    ]
)
data class Pile(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    @ColumnInfo(name = "type") override val type: PileType,
    @ColumnInfo(name = "match_id", index = true) override val matchId: Long
) : PileEntity

enum class PileType {
    Foundation, Tableau, Deck, Waste, Unknown
}