package lucassales.com.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cards",
    indices = [
        Index(value = ["figureId", "suitId"], unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            entity = Figure::class,
            parentColumns = ["id"],
            childColumns = ["figureId"]
        ),
        ForeignKey(
            entity = Suit::class,
            parentColumns = ["id"],
            childColumns = ["suitId"]
        )
    ]
)
data class Card(
    @PrimaryKey override val id: Long,
    @ColumnInfo(name = "figureId", index = true) val figureId: Long,
    @ColumnInfo(name = "suitId", index = true) val suitId: Long
) : GameEntity