package com.shared

import com.di.initKoin
import com.shared.app_entry.AppCompose
import moe.tlaster.precompose.PreComposeApplication
import org.koin.dsl.module
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused")
fun MainViewController(): UIViewController {
    initKoin(
        module = module {

        }
    )

    return PreComposeApplication {
        AppCompose()
    }
}