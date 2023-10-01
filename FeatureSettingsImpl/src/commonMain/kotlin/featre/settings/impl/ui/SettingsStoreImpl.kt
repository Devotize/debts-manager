package featre.settings.impl.ui

import feature.settings.api.ui.SettingsStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsStoreImpl : SettingsStore() {

    override val state: StateFlow<SettingsState> = MutableStateFlow(SettingsState.Default)

    override fun dispatch(action: SettingsAction) {
        when (action) {
            DoSomething -> {
                println("Doing something")
            }
        }
    }
}