package com.hpcreation.bandhanmarry.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    secondary = OrangeSecondary,
    onSecondary = Color.White,
    background = BackgroundWhite,
    onBackground = Color.Black,
    surface = BackgroundWhite,
    onSurface = Color.Black,
    outline = BluePrimary
)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    secondary = OrangeSecondary,
    onSecondary = Color.White,
    background = BackgroundWhite,
    onBackground = Color.Black,
    surface = BackgroundWhite,
    onSurface = Color.Black,
    outline = BluePrimary
)

@Composable
fun BandhanMarryTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme, typography = AppTypography, content = content
    )
}