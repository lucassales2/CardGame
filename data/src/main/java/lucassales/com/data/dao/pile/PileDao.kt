package lucassales.com.data.dao.pile

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import lucassales.com.data.entities.pile.PileEntity

@Dao
interface PileDao<in P : PileEntity> {
    @Insert
    suspend fun insert(entity: P): Long

    @Insert
    suspend fun insertAll(vararg entity: P)

    @Insert
    suspend fun insertAll(entities: List<P>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllOrIgnore(entities: List<P>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnore(entity: P)

    @Update
    suspend fun update(entity: P)

    @Delete
    suspend fun delete(entity: P): Int
}