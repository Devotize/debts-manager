package feature.settings.impl.di

import feature.settings.api.prefs.AppThemePrefs
import feature.settings.api.ui.SettingsStore
import feature.settings.impl.prefs.AppThemePrefsImpl
import feature.settings.impl.ui.SettingsStoreImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DI = module {
    singleOf(::SettingsStoreImpl).bind<SettingsStore>()
    @Suppress("OPT_IN_USAGE")
    singleOf(::AppThemePrefsImpl).bind<AppThemePrefs>()
}