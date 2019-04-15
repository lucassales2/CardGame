package lucassales.com.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cards",
    indices = [
        Index(value = ["figure"]),
        Index(value = ["suit"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = Figure::class,
            parentColumns = ["id"],
            childColumns = ["figure"]
        ),
        ForeignKey(
            entity = Suit::class,
            parentColumns = ["id"],
            childColumns = ["suit"]
        )
    ]
)
data class Card(
    @PrimaryKey override val id: Long,
    @ColumnInfo(name = "figure") val figure: Long,
    @ColumnInfo(name = "suit") val suit: Long
) : GameEntity