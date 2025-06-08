package com.hpcreation.bandhanmarry.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hpcreation.bandhanmarry.R

// Set of Material typography styles to start with
/*
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = BluePrimary
    ), headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = BluePrimary
    )
)*/

val Lobsters = FontFamily(
    Font(R.font.lobster, FontWeight.Normal),
    Font(R.font.lobster, FontWeight.Medium),
    Font(R.font.lobster, FontWeight.SemiBold),
    Font(R.font.lobster, FontWeight.Bold)
)


val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        letterSpacing = (-1).sp
    ), headlineMedium = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        letterSpacing = 0.sp,
    ), titleMedium = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp
    ), bodyLarge = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ), bodyMedium = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ), bodySmall = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp
    ), labelSmall = TextStyle(
        fontFamily = Lobsters,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    )
)
