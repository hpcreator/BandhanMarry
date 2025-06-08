package com.hpcreation.bandhanmarry.presentation.navigation

sealed class Routes(val route: String) {
    object Main : Routes("main")
    object Login : Routes("login")
    object Register : Routes("register")
    object Home : Routes("home")
}