package com.example.jetpackcomposeplayground.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.R

//declare custom fonts here
val fontFamily = FontFamily(
    Font(R.font.oswald_bold, FontWeight.Bold),
    Font(R.font.oswald_semibold, FontWeight.SemiBold),
    Font(R.font.oswald_extralight, FontWeight.ExtraLight),
    Font(R.font.oswald_light, FontWeight.Light),
    Font(R.font.oswald_medium, FontWeight.Medium),
    Font(R.font.oswald_regular, FontWeight.Normal),
)


// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = fontFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)