package com.ranamahadahmer.expensemaster.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val bgGradient = Brush.verticalGradient(colors = listOf(Color.Yellow.copy(alpha = 0.3f),
    Color.Cyan.copy(alpha = 0.06f),
    Color.Magenta.copy(green = 0.3f, alpha = 0.2f)), startY = 0.0f, endY = 2500f)