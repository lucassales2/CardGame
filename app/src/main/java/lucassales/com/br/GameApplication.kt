package lucassales.com.br

import android.app.Application
import kotlinx.coroutines.GlobalScope
import lucassales.com.br.inject.executorModule
import lucassales.com.br.inject.managerModule
import lucassales.com.br.inject.viewModelModule
import lucassales.com.core.SolitaireRules
import lucassales.com.data.databaseModule
import lucassales.com.domain.GenerateEntitiesInteractor
import lucassales.com.domain.interactorModule
import lucassales.com.domain.launchInteractor
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GameApplication : Application() {

    private val generateEntitiesInteractor by inject<GenerateEntitiesInteractor>()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GameApplication)
            modules(databaseModule, viewModelModule, executorModule, interactorModule, managerModule)
        }

        GlobalScope.launchInteractor(generateEntitiesInteractor, SolitaireRules)
    }
}