package com.ranamahadahmer.expensemaster.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MonetaryCard(icon: ImageVector,
                 title: String,
                 amount: String,
                 color: Color,
                 modifier: Modifier) {
    Surface(
        color = color, shape = RoundedCornerShape(16),
        modifier = modifier, onClick = {}) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = "", modifier = Modifier.size(30.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = title)
                Text(text = amount)
            }
        }
    }
}

@Preview
@Composable
fun MonetaryCardPreview() {
    MonetaryCard(icon = Icons.Default.KeyboardArrowDown,
        title = "Income",
        amount = "25,000.0",
        color = Color.Green.copy(red = 0.4f, alpha = 0.7f),
        modifier = Modifier
                .width(300.dp)
                .padding(12.dp)
    )
}