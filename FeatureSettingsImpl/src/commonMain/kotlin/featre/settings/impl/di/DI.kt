package featre.settings.impl.di

import featre.settings.impl.ui.SettingsStoreImpl
import feature.settings.api.ui.SettingsStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DI = module {
    singleOf(::SettingsStoreImpl).bind<SettingsStore>()
}