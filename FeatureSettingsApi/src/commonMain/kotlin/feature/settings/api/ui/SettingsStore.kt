package feature.settings.api.ui

import core.store.Action
import core.store.State
import core.store.Store
import feature.settings.api.prefs.Theme

abstract class SettingsStore :
    Store<SettingsStore.SettingsState, SettingsStore.SettingsAction>() {

    data class SettingsState(
        val message: String = "Settings Screen",
        val theme: Theme = Theme.Light,
    ) : State

    sealed interface SettingsAction : Action

    data object DoSomething : SettingsAction

    data class OnThemeChange(val isDark: Boolean) : SettingsAction

}