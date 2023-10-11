package feature.settings.impl.prefs

import com.russhwolf.settings.coroutines.FlowSettings
import feature.preferences.api.Preferences
import feature.settings.api.prefs.AppThemePrefs
import feature.settings.api.prefs.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Suppress("OPT_IN_USAGE")
class AppThemePrefsImpl(
    private val flowSettings: FlowSettings,
) : AppThemePrefs {
    override val currentValue: Flow<Theme> =
        flowSettings.getBooleanFlow(Preferences.DarkThemeEnabled, false)
            .map { if (it) Theme.Dark else Theme.Light }

    override suspend fun rememberValue(value: Theme) {
        flowSettings.putBoolean(Preferences.DarkThemeEnabled, value != Theme.Light)
    }
}