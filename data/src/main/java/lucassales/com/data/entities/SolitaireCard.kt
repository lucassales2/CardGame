package lucassales.com.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import lucassales.com.data.entities.pile.Pile

@Entity(
    tableName = "solitaire_card",
    indices = [
        Index(value = ["card_id"]),
        Index(value = ["pile_id"]),
        Index(value = ["face_up"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = Pile::class,
            childColumns = ["pile_id"],
            parentColumns = ["id"]
        ),
        ForeignKey(
            entity = Card::class,
            childColumns = ["card_id"],
            parentColumns = ["id"]
        )
    ]
)
data class SolitaireCard(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    @ColumnInfo(name = "card_id") val cardId: Long,
    @ColumnInfo(name = "pile_id") val pileId: Long,
    @ColumnInfo(name = "face_up") val faceUp: Boolean = false
) : GameEntity