package com.example.changelanguageandonbording.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.changelanguageandonbording.R
import com.example.changelanguageandonbording.components.buttons.MyButton
import com.example.changelanguageandonbording.navigation.Screen
import com.example.changelanguageandonbording.ui.theme.blurple
import com.example.changelanguageandonbording.viewModel.WelcomeViewModel


@Composable
fun Language(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    var currentLanguage by remember { mutableStateOf("en") } // Default language is English

    val context = LocalContext.current
    val configuration = context.resources.configuration

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .background(blurple),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.padding(top = 114.dp))
        Image(
            painter = painterResource(id = R.drawable.cee_face),
            contentDescription = null,
            modifier = Modifier.padding(34.3.dp)
        )
        MyButton(
            text = "English",
            onClick = {
                welcomeViewModel.saveLanguage("en")
                currentLanguage = "en"
                navController.navigate(Screen.Welcome.route)
            }
        )
        MyButton(
            text = "عربي",
            onClick = {}
        )
        MyButton(
            text = "کوردی سۆرانی",
            onClick = {
                welcomeViewModel.saveLanguage("ku")
                currentLanguage = "ku"
                navController.navigate(Screen.Welcome.route)
            }
        )
    }
    configuration.setLocale(java.util.Locale(currentLanguage))
    context.resources.updateConfiguration(configuration, context.resources.displayMetrics)
}