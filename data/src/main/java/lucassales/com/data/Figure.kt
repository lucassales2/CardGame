package lucassales.com.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "figures")
data class Figure(@PrimaryKey override val id: Long): GameEntity