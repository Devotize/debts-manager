package feature.settings.api.prefs

import feature.preferences.api.ValuePrefs

interface AppThemePrefs : ValuePrefs<Theme>

enum class Theme {
    Light, Dark
}