package com.hpcreation.bandhanmarry.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hpcreation.bandhanmarry.R
import com.hpcreation.bandhanmarry.presentation.navigation.Routes
import com.hpcreation.bandhanmarry.presentation.ui.components.HeadlineText
import com.hpcreation.bandhanmarry.presentation.ui.theme.PaleBlue
import com.hpcreation.bandhanmarry.presentation.ui.theme.SoftPink
import kotlinx.coroutines.delay


@Composable
fun MainScreen(navController: NavController) {
    LaunchedEffect(true) {
        delay(2000)
        val userLoggedIn = false // simulate logic or read from persistent storage
        navController.navigate(if (userLoggedIn) Routes.Home.route else Routes.Login.route) {
            popUpTo(Routes.Main.route) { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        SoftPink, SoftPink, PaleBlue, PaleBlue
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.app_logo),
            contentDescription = "App Logo"
        )
        HeadlineText(
            text = stringResource(R.string.app_name), style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.lobster)),
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFE53935), Color(0xFF1E88E5)
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainScreenPreview() {
    MainScreen(rememberNavController())
}