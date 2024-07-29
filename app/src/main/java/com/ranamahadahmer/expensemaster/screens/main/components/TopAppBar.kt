package com.ranamahadahmer.expensemaster.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

@Composable
fun TopAppBar() {

    Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
        Spacer(modifier = Modifier.height(8.dp))
        StatusBar()
        Spacer(modifier = Modifier.height(12.dp))
        HorizontalDivider(thickness = 0.7.dp, color = Color.Black)
    }


}

@Composable
fun StatusBar() {
    val date = LocalDate.now()
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()) {
        Text(

            text = "${date.dayOfWeek} ${date.dayOfMonth}",
            fontSize = 20.sp,
            fontWeight = FontWeight.W500

        )
        Text(

            text = date.month.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.W500
        )
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}