package com.example.changelanguageandonbording.components.circles

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.changelanguageandonbording.ui.theme.blurple
import com.example.changelanguageandonbording.ui.theme.lightPurple

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CircleIndicator(
    pagerState: PagerState
) {
    var active1 by remember { mutableStateOf(false) }
    var active2 by remember { mutableStateOf(false) }
    var active3 by remember { mutableStateOf(false) }

    val animatedWidth1: Dp by animateDpAsState(
        targetValue = if (active1) 16.dp else 8.dp,
        animationSpec = tween(
            durationMillis = 400,
            delayMillis = 20
        ),
        label = ""
    )

    val animatedWidth2: Dp by animateDpAsState(
        targetValue = if (active2) 16.dp else 8.dp,
        animationSpec = tween(
            durationMillis = 400,
            delayMillis = 20
        ),
        label = ""
    )

    val animatedWidth3: Dp by animateDpAsState(
        targetValue = if (active3) 16.dp else 8.dp,
        animationSpec = tween(
            durationMillis = 400,
            delayMillis = 20
        ),
        label = ""
    )

    when (pagerState.currentPage) {
        0 -> {
            active1 = true
            active2 = false
            active3 = false
        }
        1 -> {
            active1 = false
            active2 = true
            active3 = false

        }
        2 -> {
            active1 = false
            active2 = false
            active3 = true
        }
    }

    Row (
        modifier = Modifier
            .padding(vertical = 44.14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        MyCircle(
            width = animatedWidth1,
            height = 8.dp,
            color = if(active1) blurple else lightPurple
        )
        MyCircle(
            modifier = Modifier.padding(horizontal = 6.dp),
            width = animatedWidth2,
            height = 8.dp,
            color = if(active2) blurple else lightPurple
        )
        MyCircle(
            width = animatedWidth3,
            height = 8.dp,
            color = if(active3) blurple else lightPurple
        )
    }
}