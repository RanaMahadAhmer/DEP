package com.ranamahadahmer.expensemaster.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranamahadahmer.expensemaster.screens.main.components.MonetaryCard
import com.ranamahadahmer.expensemaster.screens.main.components.TopAppBar
import java.time.LocalDate

@Composable
fun MainScreen( ) {


    val x = Brush.verticalGradient(colors = listOf(Color.Yellow.copy(alpha = 0.3f),
        Color.Cyan.copy(alpha = 0.06f),
        Color.Magenta.copy(green = 0.3f, alpha = 0.2f) ), startY = 0.0f, endY = 2500f)

    Scaffold(modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars),
        topBar = { TopAppBar() }
    ) { innerPadding ->
        Column(modifier = Modifier
                .fillMaxSize()
                .background(x)
                .padding(innerPadding)) {
            Surface(shadowElevation = 8.dp, shape = RoundedCornerShape(4),
                modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .weight(0.8f)) {
                Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround, modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize()){
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = "Account Balance", fontSize = 15.sp, fontWeight = FontWeight.W500)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "PKR 10,000.0", fontSize = 30.sp, fontWeight = FontWeight.W500)
                    }
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        MonetaryCard(icon = Icons.Default.KeyboardArrowDown, title = "Income", amount = "25,000.0", color = Color.Green.copy(red = 0.4f, alpha = 0.7f),modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        MonetaryCard(icon = Icons.Default.KeyboardArrowUp, title = "Expense", amount = "15,000.0", color = Color.Red.copy(green = 0.1f, alpha = 0.7f),modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))




        }

    }
}





@Composable
@Preview
fun MainScreenPreview(){
    MainScreen()
}