package com.example.changelanguageandonbording.screens.onBoardingScreen

import androidx.annotation.DrawableRes
import com.example.changelanguageandonbording.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: Int,
    val description: Int
){
    object First : OnBoardingPage(
        image = R.drawable.onb1,
        title = R.string.title1,
        description = R.string.description1
    )
    object Second : OnBoardingPage(
        image = R.drawable.onb2,
        title = R.string.title2,
        description = R.string.description2
    )
    object Third : OnBoardingPage(
        image = R.drawable.onb3,
        title = R.string.title3,
        description = R.string.description3
    )
}
