package lucassales.com.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import lucassales.com.data.entities.GameEntity

interface EntityDao<in E : GameEntity> {
    @Insert
    suspend fun insert(entity: E): Long

    @Insert
    suspend fun insertAll(vararg entity: E)

    @Insert
    suspend fun insertAll(entities: List<E>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllOrIgnore(entities: List<E>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnore(entity: E)

    @Update
    suspend fun update(entity: E)

    @Update
    suspend fun updateAll(entities: List<E>)

    @Delete
    suspend fun delete(entity: E): Int
}