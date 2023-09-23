package com.shared

import com.shared.ui.AppCompose
import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused")
fun MainViewController(): UIViewController {
    return PreComposeApplication {
        AppCompose()
    }
}