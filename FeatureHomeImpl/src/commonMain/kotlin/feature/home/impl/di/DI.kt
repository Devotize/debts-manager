package feature.home.impl.di

import feature.home.api.ui.HomeStore
import feature.home.impl.ui.HomeStoreImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DI = module {
    singleOf(::HomeStoreImpl).bind<HomeStore>()
}