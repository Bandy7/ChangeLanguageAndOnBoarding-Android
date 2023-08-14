package com.example.changelanguageandonbording.components.circles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.changelanguageandonbording.R
import com.example.changelanguageandonbording.ui.theme.blurple

@Composable
fun MyCircle(
    modifier: Modifier = Modifier,
    width: Dp = 62.dp,
    height: Dp = 62.dp,
    color: Color = blurple,
    isImage: Boolean = false
) {
    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .clip(AlertDialogDefaults.shape)
            .background(color, shape = RoundedCornerShape(50.dp)),
        contentAlignment = Alignment.Center
    ){
        if (isImage)
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_2),
                contentDescription = null)
    }
}