package lucassales.com.br.inject

import android.preference.PreferenceManager
import lucassales.com.br.manager.PrefManagerImpl
import lucassales.com.core.manager.PrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val managerModule = module {
    factory<PrefManager> { PrefManagerImpl(get()) }
    factory { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
}