package com.ranamahadahmer.expensemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranamahadahmer.expensemaster.ui.theme.ExpenseMasterTheme
import java.time.LocalDate
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseMasterTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting( ) {
    val date = LocalDate.now()
    Scaffold(modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars),
        topBar = {
            Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)){
                Spacer(modifier =Modifier.height(8.dp))
                Row  (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()){
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
                Spacer(modifier =Modifier.height(12.dp))
                HorizontalDivider(thickness = 0.7.dp, color = Color.Black)
            }

        }
    ) { innerPadding ->
        Column(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {
            Box(modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
                    .weight(0.8f)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(12.dp))) {
                Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround, modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize()){
                    Spacer(modifier =Modifier.height(1.dp))
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = "Account Balance", fontSize = 15.sp, fontWeight = FontWeight.W500)
                        Spacer(modifier =Modifier.height(8.dp))
                        Text(text = "PKR 100,000.0", fontSize = 30.sp, fontWeight = FontWeight.W500)
                    }
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Card(modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f), onClick = { }) {
                            Row (modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically){
                                Icon(Icons.Outlined.Home, contentDescription = "")
                                Column {

                                    Text(text = "Income")
                                    Text(text = "25,000.0")
                                }
                            }
                        }
                        Spacer(modifier =Modifier.width(12.dp))
                        Card(modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f), onClick = { }) {
                            Row (modifier = Modifier.padding(12.dp)){

                                Column {

                                    Text(text = "Income")
                                    Text(text = "25,000.0")
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Box(modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
                    .weight(1f)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(12.dp))) {
                Text(
                    text = "Hello, World!",
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 30.sp
                )
            }


        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExpenseMasterTheme {
        Greeting()
    }
}