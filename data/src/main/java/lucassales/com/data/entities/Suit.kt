package lucassales.com.data.entities

import androidx.room.Entity

@Entity(tableName = "suits")
data class Suit(override val id: Long): GameEntity