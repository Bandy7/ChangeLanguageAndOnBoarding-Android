package com.example.changelanguageandonbording.components.circles

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.changelanguageandonbording.ui.theme.blurple
import com.example.changelanguageandonbording.ui.theme.lightPurple

@Preview(showBackground = true)
@Composable
fun CanvasCircle(
    sweepAngle: Float = 120f
) {
    Canvas(
        modifier = Modifier
            .size(115.dp)
            .aspectRatio(1f)
    ) {

        val strokeWidth = 220f

        drawArc(
            color = lightPurple,
            useCenter = false,
            topLeft = Offset(50f, 50f),
            size = Size(strokeWidth, strokeWidth),
            startAngle = 360f,
            sweepAngle = 360f,
            style = Stroke(3.dp.toPx()),

            )
        drawArc(
            color = blurple,
            useCenter = false,
            topLeft = Offset(50f, 50f),
            size = Size(strokeWidth, strokeWidth),
            startAngle = 210f,
            sweepAngle = sweepAngle,
            style = Stroke(5.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}