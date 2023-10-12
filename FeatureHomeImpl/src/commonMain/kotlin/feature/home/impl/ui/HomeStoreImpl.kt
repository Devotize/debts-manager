package feature.home.impl.ui

import feature.home.api.ui.HomeStore
import feature.navigation.api.bottom_sheet.controller.BottomSheetController
import feature.navigation.api.bottom_sheet.model.BSDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeStoreImpl(
    private val bottomSheetController: BottomSheetController
) : HomeStore() {
    override val state: StateFlow<HomeState> = MutableStateFlow(HomeState())

    override fun dispatch(action: HomeAction) {
        when (action) {
            OpenBottomSheet -> bottomSheetController.open(BSDestination.Default)
        }
    }
}