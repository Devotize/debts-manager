package com.shared.ui.scenes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.shared.components.DividerFull
import com.shared.theme.H1_20Medium
import com.shared.theme.LargePadding
import com.shared.theme.XLargePadding
import com.shared.utils.rememberKoin
import com.sychev.db.common.MR
import dev.icerock.moko.resources.compose.stringResource
import feature.settings.api.prefs.Theme
import feature.settings.api.ui.SettingsStore

@Composable
fun SettingsScene(
    store: SettingsStore = rememberKoin(),
) {
    val state by store.state.collectAsState()
    val darkThemeEnabled = state.theme == Theme.Dark
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        Row(
            modifier = Modifier.padding(horizontal = XLargePadding, vertical = LargePadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = stringResource(MR.strings.dark_theme),
                style = H1_20Medium
            )
            Switch(darkThemeEnabled, onCheckedChange = {
                store.dispatch(SettingsStore.OnThemeChange(it))
            })
        }
        DividerFull()
        Text(
            modifier = Modifier.clickable {
                store.dispatch(SettingsStore.DoSomething)
            },
            text = "Navigate to test scene"
        )

    }
}