package com.example.changelanguageandonbording.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.changelanguageandonbording.R
import com.example.changelanguageandonbording.ui.theme.blurple
import com.example.changelanguageandonbording.viewModel.SplashViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import java.util.Locale

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    var startAnimation by remember { mutableStateOf(false) }
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutLinearInEasing
            )
        )
        startAnimation = true
        delay(1500)
        navController.popBackStack()
        navController.navigate(viewModel.startDestination.value)
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor( color = blurple )
        systemUiController.setNavigationBarColor(color = blurple)
    }

    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    configuration.setLocale(Locale(viewModel.lang.value))
    context.resources.updateConfiguration(configuration,context.resources.displayMetrics)

    Splash()
}

@Preview(showBackground = true)
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(blurple)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.splash_screen),
            contentDescription = null
        )
    }
}