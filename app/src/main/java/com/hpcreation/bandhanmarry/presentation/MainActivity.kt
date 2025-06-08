package com.hpcreation.bandhanmarry.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.hpcreation.bandhanmarry.presentation.navigation.AppNavHost
import com.hpcreation.bandhanmarry.presentation.ui.theme.BandhanMarryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BandhanMarryTheme {
                val navController = rememberNavController()
                Surface {
                    AppNavHost(navController = navController)
                }
            }
        }
    }
}