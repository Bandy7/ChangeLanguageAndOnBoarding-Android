package com.example.changelanguageandonbording.components.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.changelanguageandonbording.components.MyText

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    color: Color = Color.White,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp)
) {
    Button(
        colors = ButtonDefaults.buttonColors(color),
        onClick = onClick,
        modifier = modifier
            .padding(4.dp)
            .width(238.dp)
            .height(56.dp),
        shape = shape
    ) {
        MyText(
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}