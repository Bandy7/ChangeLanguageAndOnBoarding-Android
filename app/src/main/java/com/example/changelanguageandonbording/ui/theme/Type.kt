package com.example.changelanguageandonbording.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.changelanguageandonbording.R


val workSans = FontFamily(
    Font(R.font.work_sans_bold, FontWeight.W700),
    Font(R.font.work_sans_medium, FontWeight.W500)
)

val bahij = FontFamily(
    Font(R.font.bahij_the_sans_arabic_bold, FontWeight.W700),
    Font(R.font.bahij_the_sans_arabic_light, FontWeight.W500)
)

val TypographyEn = Typography(
    bodyLarge = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        lineHeight = 28.15.sp,
        letterSpacing = 0.6.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.W700,
        fontSize = 14.sp,
        lineHeight = 16.42.sp,
        letterSpacing = 0.4.sp
    ),
    bodySmall = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 14.08.sp,
        letterSpacing = 0.2.sp
    ),
)

val TypographyKu = Typography(
    bodyLarge = TextStyle(
        fontFamily = bahij,
        fontWeight = FontWeight.W700,
        fontSize = 24.sp,
        lineHeight = 28.15.sp,
        letterSpacing = 0.6.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = bahij,
        fontWeight = FontWeight.W700,
        fontSize = 14.sp,
        lineHeight = 16.42.sp,
        letterSpacing = 0.4.sp
    ),
    bodySmall = TextStyle(
        fontFamily = bahij,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 14.08.sp,
        letterSpacing = 0.2.sp
    ),
)