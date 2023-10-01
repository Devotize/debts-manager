package com.shared.ui.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScene(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.secondary)) {
        Text(
            modifier = Modifier.clickable { onClick.invoke() },
            text = "This is settings scene",
        )
    }
}