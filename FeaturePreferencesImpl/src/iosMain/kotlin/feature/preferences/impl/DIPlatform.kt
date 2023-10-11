package feature.preferences.impl

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

@ExperimentalSettingsApi
internal actual val DIPlatform = module {
    single { NSUserDefaultsSettings(NSUserDefaults.new()!!).toFlowSettings(dispatcher = Dispatchers.IO) }
}
