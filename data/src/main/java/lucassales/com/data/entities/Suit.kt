package lucassales.com.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "suits")
data class Suit(@PrimaryKey override val id: Long) : GameEntity