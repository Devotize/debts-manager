@file:OptIn(ExperimentalMaterialApi::class)

package feature.navigation.impl.bottom_sheet

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import feature.navigation.api.bottom_sheet.controller.BottomSheetController
import feature.navigation.api.bottom_sheet.controller.SheetStateHolder
import feature.navigation.api.bottom_sheet.model.BSDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class BottomSheetControllerImpl : BottomSheetController, SheetStateHolder {

    private var _state: ModalBottomSheetState? = null
    private val state by lazy { _state ?: error("Bottom sheet state has not been provided yet!") }

    private lateinit var scope: CoroutineScope

    override fun open(bs: BSDestination) {
        current.value = bs
        scope.launch {
            state.show()
        }
    }

    override fun close() {
        scope.launch {
            state.hide()
        }
    }

    override val current: MutableState<BSDestination> = mutableStateOf(BSDestination.Default)

    override fun setSheetState(state: ModalBottomSheetState) {
        if (_state != null) {
            error("Sheet state has been already set!")
        }
        _state = state
    }

    override fun setScope(scope: CoroutineScope) {
        this.scope = scope
    }
}