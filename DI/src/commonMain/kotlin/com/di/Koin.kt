package com.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(module: Module) = startKoin {
    modules(*appModules.toTypedArray(), module)
}

private val appModules = listOf(
    feature.settings.impl.di.DI,
    feature.navigation.impl.di.DI,
    feature.preferences.impl.DI,
)