package com.shared.ui.scenes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.home.api.ui.HomeStore
import kotlinx.coroutines.launch
import utils.getSingle

@Composable
fun HomeScene(store: HomeStore = getSingle()) {

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier,
            text = "This is home scene",
        )
        Spacer(Modifier.height(24.dp))
        Text(
            modifier = Modifier.clickable {
                scope.launch {
                    store.dispatch(HomeStore.OpenBottomSheet)
                }
            },
            text = "Open Bottom Sheet"
        )
    }

}