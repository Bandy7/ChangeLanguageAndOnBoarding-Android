package com.example.changelanguageandonbording.screens.onBoardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.changelanguageandonbording.components.MyText


@Composable
fun OnBoardingScreenDesign(
    onBoardingPage: OnBoardingPage,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .width(390.dp)
                .height(402.dp),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )

        MyText(
            text = stringResource(id = onBoardingPage.title),
            modifier = Modifier.padding(top = 24.48.dp),
            style = MaterialTheme.typography.bodyLarge,
        )

        MyText(
            text = stringResource(id = onBoardingPage.description),
            modifier = Modifier
                .padding(horizontal = 70.dp)
                .padding(top = 15.72.dp),
            style = MaterialTheme.typography.bodySmall,
        )
    }
}