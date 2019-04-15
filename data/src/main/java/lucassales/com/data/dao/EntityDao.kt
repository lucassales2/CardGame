package lucassales.com.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import lucassales.com.data.entities.GameEntity

interface EntityDao<in E : GameEntity> {
    @Insert
    suspend fun insert(entity: E): Long

    @Insert
    suspend fun insertAll(vararg entity: E)

    @Insert
    suspend fun insertAll(entities: List<E>)

    @Update
    suspend fun update(entity: E)

    @Delete
    suspend fun delete(entity: E): Int
}