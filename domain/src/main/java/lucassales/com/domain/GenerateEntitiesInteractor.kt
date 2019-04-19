package lucassales.com.domain

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.core.Rules
import lucassales.com.core.manager.PrefManager
import lucassales.com.data.dao.CardDao
import lucassales.com.data.dao.FigureDao
import lucassales.com.data.dao.SuitDao
import lucassales.com.data.entities.Card

class GenerateEntitiesInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers,
    private val cardDao: CardDao,
    private val suitDao: SuitDao,
    private val figureDao: FigureDao,
    private val prefManager: PrefManager
) : Interactor<Rules> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Rules) {
        if (!prefManager.getBoolean(HasCreated, false)) {
            prefManager.setBoolean(HasCreated, true)
            figureDao.insertAllOrIgnore(input.validFigures.toList())
            suitDao.insertAllOrIgnore(input.validSuits.toList())
            for (i in 0 until input.validFigures.size * input.validSuits.size) {
                val suit = input.validSuits[i / input.validFigures.size]
                val figure = input.validFigures[i % input.validFigures.size]
                val cardId = cardDao.insert(
                    Card(
                        id = i + 1L,
                        suitId = suit.id,
                        figureId = figure.id
                    )
                )
            }
        }
    }

    companion object {
        private const val HasCreated = "has_created"
    }
}