package feature.navigation.impl.di

import feature.navigation.api.bottom_sheet.controller.BottomSheetController
import feature.navigation.api.bottom_sheet.controller.SheetStateHolder
import feature.navigation.api.router.NavigatorInitializer
import feature.navigation.api.router.Router
import feature.navigation.impl.bottom_sheet.BottomSheetControllerImpl
import feature.navigation.impl.router.RouterImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.binds
import org.koin.dsl.module

val DI = module {
    singleOf(::RouterImpl).binds(arrayOf(Router::class, NavigatorInitializer::class))
    singleOf(::BottomSheetControllerImpl).binds(
        arrayOf(
            BottomSheetController::class,
            SheetStateHolder::class
        )
    )
}