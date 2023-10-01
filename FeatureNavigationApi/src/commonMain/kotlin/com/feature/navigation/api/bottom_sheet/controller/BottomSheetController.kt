package com.feature.navigation.api.bottom_sheet.controller

import com.feature.navigation.api.bottom_sheet.model.BSDestination

interface BottomSheetController {

    fun open(bs: BSDestination)

    fun close()

}