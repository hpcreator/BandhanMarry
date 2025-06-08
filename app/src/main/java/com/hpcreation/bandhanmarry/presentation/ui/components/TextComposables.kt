package com.hpcreation.bandhanmarry.presentation.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun HeadlineText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = text, style = style, textAlign = textAlign, modifier = modifier, color = color
    )
}

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 14.sp,
) {
    Text(
        text = text, style = MaterialTheme.typography.titleMedium.copy(
            color = color, fontWeight = fontWeight
        ), textAlign = textAlign, fontSize = fontSize, modifier = modifier
    )
}

@Composable
fun DescriptionText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text, style = MaterialTheme.typography.bodyMedium.copy(
            color = color
        ), textAlign = textAlign, modifier = modifier
    )
}

@Composable
fun SmallClickableText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.secondary,
    underline: Boolean = true,
    onClick: () -> Unit,
) {
    val styledText = if (underline) {
        AnnotatedString(
            text,
            spanStyle = androidx.compose.ui.text.SpanStyle(textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline)
        )
    } else {
        AnnotatedString(text)
    }

    ClickableText(
        text = styledText,
        onClick = { onClick() },
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium.copy(
            color = color, fontWeight = FontWeight.SemiBold
        )
    )
}