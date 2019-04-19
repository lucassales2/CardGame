package lucassales.com.data

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import lucassales.com.data.SolitaireRules.validFigures
import lucassales.com.data.SolitaireRules.validSuits
import lucassales.com.data.entities.Card
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameDatabaseTest {

    private lateinit var database: GameDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            GameDatabase::class.java
        ).build()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun test() = runBlocking(TestCoroutineDispatcher()) {
        database.figureDao().insertAll(validFigures.toList())
        database.suitDao().insertAll(validSuits.toList())
        for (i in 0 until validFigures.size * validSuits.size) {
            val suit = validSuits[i / validFigures.size]
            val figure = validFigures[i % validFigures.size]
            database.cardDao().insertOrIgnore(
                Card(
                    id = (i + 1).toLong(),
                    suitId = suit.id,
                    figureId = figure.id
                )
            )
        }
        assert(database.cardDao().allIds().size == 52)
    }
}