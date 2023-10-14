package feature.navigation.api.bottom_sheet.controller

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import feature.navigation.api.bottom_sheet.model.BSDestination
import feature.navigation.api.bottom_sheet.model.BSDestination.Default
import feature.navigation.api.bottom_sheet.model.BSDestination.Test2
import feature.navigation.api.bottom_sheet.scenes.TestBottomSheet
import feature.navigation.api.bottom_sheet.scenes.TestBottomSheet2
import kotlinx.coroutines.CoroutineScope
import utils.getSingle

interface BottomSheetController {

    fun open(bs: BSDestination)

    fun close()

}

interface SheetStateHolder {
    val current: State<BSDestination>

    @OptIn(ExperimentalMaterialApi::class)
    fun setSheetState(state: ModalBottomSheetState)

    fun setScope(scope: CoroutineScope)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetLayout(controller: SheetStateHolder = getSingle()) {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
    LaunchedEffect(key1 = true) {
        controller.setSheetState(bottomSheetState)
    }
    val scope = rememberCoroutineScope()
    LaunchedEffect(scope) {
        controller.setScope(scope)
    }
    val currentBS by controller.current
    ModalBottomSheetLayout(
        sheetContent = {
            when (currentBS) {
                Default -> TestBottomSheet()
                Test2 -> TestBottomSheet2()
            }
        },
        content = {
        },
        sheetState = bottomSheetState
    )
}