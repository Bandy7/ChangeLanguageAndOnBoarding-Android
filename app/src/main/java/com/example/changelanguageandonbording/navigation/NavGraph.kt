package com.example.changelanguageandonbording.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.changelanguageandonbording.screens.HomeScreen
import com.example.changelanguageandonbording.screens.Language
import com.example.changelanguageandonbording.screens.SplashScreen
import com.example.changelanguageandonbording.screens.WelcomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route //viewModel.startDestination.value
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Language.route){
            Language(navController = navController)
        }
        composable(route = Screen.Welcome.route){
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route){
            HomeScreen()
        }
    }
}