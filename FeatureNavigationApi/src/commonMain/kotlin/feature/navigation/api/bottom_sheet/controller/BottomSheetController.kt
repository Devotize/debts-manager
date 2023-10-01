package feature.navigation.api.bottom_sheet.controller

import feature.navigation.api.bottom_sheet.model.BSDestination

interface BottomSheetController {

    fun open(bs: BSDestination)

    fun close()

}