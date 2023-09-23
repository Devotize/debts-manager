package com.shared.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable


private val LightColors = darkColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    error = error,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
)

@Composable
fun CustomAppTheme(
    /*darkTheme: Boolean = isSystemInDarkTheme(), not used now*/
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColors,
        typography = CustomTypography,
        shapes = CustomShapes,
        content = content,
    )
}
