package com.shared.ui.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.shared.utils.rememberKoin
import feature.settings.api.ui.SettingsStore

@Composable
fun SettingsScene(
    store: SettingsStore = rememberKoin(),
    onClick: () -> Unit,
) {
    val state by store.state.collectAsState()
    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.secondary)) {
        Text(
            modifier = Modifier.clickable { onClick.invoke() },
            text = state.message,
        )
    }
}