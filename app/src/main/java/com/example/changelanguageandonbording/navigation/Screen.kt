package com.example.changelanguageandonbording.navigation

sealed class Screen(val route: String){
    object Splash : Screen(route = "splash_screen")
    object Language : Screen(route = "language_screen")
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")
}
