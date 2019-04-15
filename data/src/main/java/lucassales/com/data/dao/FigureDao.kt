package lucassales.com.data.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Flowable
import lucassales.com.data.entities.Figure

@Dao
abstract class FigureDao : EntityDao<Figure> {

    @Query("SELECT * FROM figures")
    abstract fun all(): Flowable<Figure>
}