package com.example.changelanguageandonbording.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.changelanguageandonbording.components.buttons.NextButtonWithSkip
import com.example.changelanguageandonbording.components.circles.CircleIndicator
import com.example.changelanguageandonbording.navigation.Screen
import com.example.changelanguageandonbording.screens.onBoardingScreen.OnBoardingPage
import com.example.changelanguageandonbording.screens.onBoardingScreen.OnBoardingScreenDesign
import com.example.changelanguageandonbording.viewModel.WelcomeViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

        Box(
            Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                HorizontalPager(
                    pageCount = pages.size,
                    state = pagerState,
                    verticalAlignment = Alignment.Top
                ) {position ->
                    OnBoardingScreenDesign(onBoardingPage = pages[position])
                }
            }
            Column (
                Modifier
                    .padding(bottom = 22.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){
                CircleIndicator(pagerState = pagerState)
                NextButtonWithSkip(
                    isSkipVisible = pagerState.currentPage != 2,
                    pagerState = pagerState,
                    nextAction = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                welcomeViewModel.saveOnBoardingState(completed = true)
                                navController.navigate(Screen.Home.route){
                                    navController.popBackStack(Screen.Language.route, inclusive = true)
                                }
                            } else {
                                scope.launch {
                                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                                }
                            }
                        }
                    },
                    skipAction = {
                        welcomeViewModel.saveOnBoardingState(completed = true)
                        navController.navigate(Screen.Home.route){
                            navController.popBackStack(Screen.Language.route, inclusive = true)
                        }
                    }
                )
            }
        }
}