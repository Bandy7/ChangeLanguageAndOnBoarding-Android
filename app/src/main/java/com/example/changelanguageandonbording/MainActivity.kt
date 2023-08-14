package com.example.changelanguageandonbording

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.changelanguageandonbording.navigation.Screen
import com.example.changelanguageandonbording.navigation.SetupNavGraph
import com.example.changelanguageandonbording.ui.theme.ChangeLanguageAndOnBordingTheme
import com.example.changelanguageandonbording.ui.theme.blurple
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ChangeLanguageAndOnBordingTheme {

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val coroutineScope = rememberCoroutineScope()

                val systemUiController = rememberSystemUiController()

                SideEffect {
                    coroutineScope.launch {
                        delay(100)
                        when(currentRoute){
                            Screen.Language.route -> {
                                systemUiController.setStatusBarColor( color = blurple )
                                systemUiController.setNavigationBarColor(color = blurple)
                            }
                            Screen.Welcome.route -> {
                                systemUiController.setStatusBarColor( color = Color.White )
                                systemUiController.setNavigationBarColor(color = Color.White)
                            }
                            Screen.Home.route -> {
                                systemUiController.setStatusBarColor( color = Color.White )
                                systemUiController.setNavigationBarColor(color = Color.White)
                            }
                        }
                    }
                }
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}