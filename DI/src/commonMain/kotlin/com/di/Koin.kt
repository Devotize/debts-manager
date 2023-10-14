package com.di

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(module: Module) = startKoin {
    Napier.base(DebugAntilog())
    modules(*appModules.toTypedArray(), module)
}

private val appModules = listOf(
    feature.settings.impl.di.DI,
    feature.navigation.impl.di.DI,
    feature.preferences.impl.DI,
    feature.home.impl.di.DI
)