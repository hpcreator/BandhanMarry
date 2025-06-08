package com.hpcreation.bandhanmarry.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hpcreation.bandhanmarry.presentation.ui.screen.HomeScreen
import com.hpcreation.bandhanmarry.presentation.ui.screen.LoginScreen
import com.hpcreation.bandhanmarry.presentation.ui.screen.MainScreen
import com.hpcreation.bandhanmarry.presentation.ui.screen.RegisterScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Main.route) {
        composable(Routes.Main.route) {
            MainScreen(navController)
        }
        composable(Routes.Login.route) {
            LoginScreen(navController)
        }
        composable(Routes.Register.route) {
            RegisterScreen(navController)
        }
        composable(Routes.Home.route) {
            HomeScreen()
        }
    }
}