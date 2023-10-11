package com.shared.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.shared.utils.rememberKoin
import feature.settings.api.prefs.AppThemePrefs
import feature.settings.api.prefs.Theme


private val LightColors = lightColors(
    primary = primaryLight,
    primaryVariant = primaryVariantLight,
    secondary = secondaryLight,
    secondaryVariant = secondaryVariantLight,
    background = backgroundLight,
    surface = surfaceLight,
    error = errorLight,
    onPrimary = onPrimaryLight,
    onSecondary = onSecondaryLight,
    onBackground = onBackgroundLight,
    onSurface = onSurfaceLight,
    onError = onErrorLight,
)

private val DarkColor = darkColors(
    primary = primaryDark,
    primaryVariant = primaryVariantDark,
    secondary = secondaryDark,
    secondaryVariant = secondaryVariantDark,
    background = backgroundDark,
    surface = surfaceDark,
    error = errorDark,
    onPrimary = onPrimaryDark,
    onSecondary = onSecondaryDark,
    onBackground = onBackgroundDark,
    onSurface = onSurfaceDark,
    onError = onErrorDark,
)

@Composable
fun CustomAppTheme(
    appThemePrefs: AppThemePrefs = rememberKoin(),
    content: @Composable () -> Unit
) {
    val theme by appThemePrefs.currentValue.collectAsState(Theme.Light)
    MaterialTheme(
        colors = if (theme == Theme.Light) LightColors else DarkColor,
        typography = CustomTypography,
        shapes = CustomShapes,
        content = content,
    )
}
