package com.example.changelanguageandonbording.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MyText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color(0xFF000000),
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = text,
        color = color,
        style = style,
        textAlign = TextAlign.Center
    )
}