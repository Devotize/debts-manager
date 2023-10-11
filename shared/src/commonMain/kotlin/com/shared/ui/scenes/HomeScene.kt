package com.shared.ui.scenes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScene() {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
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
                    bottomSheetState.show()
                }
            },
            text = "Open Bottom Sheet"
        )
    }

    ModalBottomSheetLayout(
        sheetContent = {
            Text("This is sheet content")
        },
        content = {
        },
        sheetState = bottomSheetState
    )
}