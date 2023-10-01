package feature.settings.api.ui

import core.store.Action
import core.store.State
import core.store.Store

abstract class SettingsStore :
    Store<SettingsStore.SettingsState, SettingsStore.SettingsAction>() {

    data class SettingsState(
        val message: String,
    ) : State {
        companion object {
            val Default = SettingsState(
                message = "Settings Screen"
            )
        }
    }

    sealed interface SettingsAction : Action

    data object DoSomething : SettingsAction

}