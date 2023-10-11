package feature.settings.impl.ui

import feature.settings.api.prefs.AppThemePrefs
import feature.settings.api.prefs.Theme
import feature.settings.api.ui.SettingsStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsStoreImpl(
    private val appThemePrefs: AppThemePrefs,
) : SettingsStore() {

    override val state: StateFlow<SettingsState> = appThemePrefs.currentValue.map {
        SettingsState(theme = it)
    }.stateIn(this, SharingStarted.Eagerly, SettingsState())

    override fun dispatch(action: SettingsAction) {
        when (action) {
            DoSomething -> {
                println("Doing something")
            }

            is OnThemeChange -> {
                launch {
                    appThemePrefs.rememberValue(if (action.isDark) Theme.Dark else Theme.Light)
                }
            }
        }
    }
}