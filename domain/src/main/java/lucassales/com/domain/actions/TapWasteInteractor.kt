package lucassales.com.domain.actions

import kotlinx.coroutines.CoroutineDispatcher
import lucassales.com.domain.AppCoroutineDispatchers
import lucassales.com.domain.Interactor

class TapWasteInteractor(
    appCoroutineDispatchers: AppCoroutineDispatchers
) : Interactor<TapWasteInteractor.Input> {
    override val dispatcher: CoroutineDispatcher = appCoroutineDispatchers.io

    override suspend fun invoke(input: Input) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    data class Input(val wasteId: Long)
}