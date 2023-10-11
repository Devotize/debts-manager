package com.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shared.theme.EliteDividerLight
import com.shared.theme.XLargePadding

@Composable
fun Divider(
    modifier: Modifier = Modifier,
    color: Color = EliteDividerLight,
) = DividerFull(modifier.padding(horizontal = XLargePadding), color)

@Composable
fun DividerFull(
    modifier: Modifier = Modifier,
    color: Color = EliteDividerLight
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(color)
    )
}

@Composable
fun DividerVertical(
    modifier: Modifier = Modifier,
    color: Color = EliteDividerLight
) {
    Box(
        modifier = modifier
            .width(0.5.dp)
            .background(color)
    )
}
