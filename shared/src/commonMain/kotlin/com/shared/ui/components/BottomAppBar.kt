package com.shared.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.shared.components.DividerFull
import com.shared.theme.BottomBarHeight
import com.shared.theme.BottomBarImageSize
import com.shared.theme.C3_10Medium
import com.shared.theme.EliteTextPrimary
import com.sychev.db.common.MR
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.stringResource
import feature.navigation.api.router.AppScene
import feature.navigation.api.router.Router
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.PopUpTo

@Composable
fun BottomBar(
    router: Router,
) {
    val state by router.currentScene.collectAsState()
    Box(
        modifier = Modifier
            .height(BottomBarHeight)
    ) {
        Column {
            DividerFull()
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp,
                modifier = Modifier.weight(1f)
            ) {
                bottomBarMenu.forEach {
                    BottomBarItem(
                        text = it.text,
                        icon = it.icon,
                        isSelected = state == it.scene,
                        onClick = {
                            router.navigateTo(
                                it.scene,
                                navOptions = NavOptions(
                                    launchSingleTop = true,
                                    popUpTo = PopUpTo.First()
                                )
                            )
                        }
                    )
                }
            }
        }
    }

}

@Composable
fun RowScope.BottomBarItem(
    text: StringResource,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val color = if (isSelected) MaterialTheme.colors.primary else EliteTextPrimary
    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = onClick
            ),
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                icon,
                modifier = Modifier.size(BottomBarImageSize),
                colorFilter = ColorFilter.tint(color),
                contentDescription = null,
            )
            Text(
                text = stringResource(text),
                style = C3_10Medium,
                color = color
            )
        }
    }
}

data class BottomBarItemData(
    val text: StringResource,
    val icon: ImageVector,
    val scene: AppScene,
)

val bottomBarMenu by lazy {
    listOf(
        BottomBarItemData(
            text = MR.strings.home_text,
            icon = Icons.Default.Home,
            scene = AppScene.Home
        ),
        BottomBarItemData(
            text = MR.strings.settings_text,
            icon = Icons.Default.Settings,
            scene = AppScene.Settings
        ),
    )
}