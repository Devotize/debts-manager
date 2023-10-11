package feature.preferences.impl

import org.koin.core.module.Module
import org.koin.dsl.module

val DI = module {
    includes(DIPlatform)
}

internal expect val DIPlatform: Module
