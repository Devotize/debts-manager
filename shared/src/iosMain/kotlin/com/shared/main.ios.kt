package com.shared

import androidx.compose.ui.window.ComposeUIViewController
import com.shared.ui.AppCompose
import platform.UIKit.UIViewController

@Suppress("FunctionName", "unused")
fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        AppCompose()
    }
}