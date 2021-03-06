package lucassales.com.data

import android.os.Debug
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        val builder = Room.databaseBuilder(androidContext(), GameDatabase::class.java, "game.db")
            .fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        builder.build()
    }

    single { get<GameDatabase>().cardDao() }
    single { get<GameDatabase>().figureDao() }
    single { get<GameDatabase>().suitDao() }
    single { get<GameDatabase>().matchDao() }
    single { get<GameDatabase>().pileDao() }
    single { get<GameDatabase>().solitaireCardDao() }
}