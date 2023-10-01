package com.di

import feature.navigation.impl.di.DI
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(module: Module) = startKoin {
    modules(*appModules.toTypedArray(), module)
}

private val appModules = listOf(
    DI,
    featre.settings.impl.di.DI
)