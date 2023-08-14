package com.example.changelanguageandonbording.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.changelanguageandonbording.R
import com.example.changelanguageandonbording.components.MyText
import com.example.changelanguageandonbording.components.circles.CanvasCircle
import com.example.changelanguageandonbording.components.circles.MyCircle
import com.example.changelanguageandonbording.ui.theme.typeGrey

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NextButtonWithSkip(
    nextAction: () -> Unit,
    skipAction: () -> Unit,
    isSkipVisible: Boolean = true,
    pagerState: PagerState
) {
    val activeCircle = remember { mutableStateOf(120f) }

    val animatedText by animateColorAsState(
        targetValue = if (isSkipVisible) typeGrey else Color.Transparent,
        animationSpec =  tween(
            durationMillis = 500,
            delayMillis = 20
            ),
        label = ""
    )

    val activeCircle1 by animateFloatAsState(
        targetValue = activeCircle.value,
        animationSpec = tween(500),
        label = ""
    )
    when (pagerState.currentPage) {
        0 -> {
            activeCircle.value = 120f
        }
        1 -> {
            activeCircle.value = 240f
        }
        2 -> {
            activeCircle.value = 360f
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box (
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            CanvasCircle(activeCircle1)
            MyCircle(
                isImage = true,
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ){
                        activeCircle.value = activeCircle.value + 120f
                        nextAction()
                    }
            )
        }
        MyText(
            text = stringResource(id = R.string.skipButton),
            color = animatedText,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { skipAction() },
        )
    }
}