package lucassales.com.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class Match(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0L,
    val originalCards: List<Long>,
    var moves: Int = 0
) : GameEntity