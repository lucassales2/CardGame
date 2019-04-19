package lucassales.com.domain

import lucassales.com.domain.actions.TapDeckInteractor
import lucassales.com.domain.actions.TapWasteInteractor
import lucassales.com.domain.create.CreateGameInteractor
import lucassales.com.domain.create.CreatePileInteractor
import lucassales.com.domain.create.CreateSolitaireCardInteractor
import lucassales.com.domain.solitaire.GetMatchByIdInteractor
import org.koin.dsl.module

val interactorModule = module {
    factory { GenerateEntitiesInteractor(get(), get(), get(), get(), get()) }
    factory { CreatePileInteractor(get(), get()) }
    factory { CreateGameInteractor(get(), get(), get(), get(), get(), get()) }
    factory { CreateSolitaireCardInteractor(get(), get()) }
    factory { GetMatchByIdInteractor(get(), get()) }
    factory { TapWasteInteractor(get()) }
    factory { TapDeckInteractor(get(), get(), get()) }
}