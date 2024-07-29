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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranamahadahmer.expensemaster.screens.main.components.Summary
import com.ranamahadahmer.expensemaster.screens.main.components.TopAppBar
import java.time.LocalDate

@Composable
fun MainScreen() {


    val x = Brush.verticalGradient(colors = listOf(Color.Yellow.copy(alpha = 0.3f),
        Color.Cyan.copy(alpha = 0.06f),
        Color.Magenta.copy(green = 0.3f, alpha = 0.2f)), startY = 0.0f, endY = 2500f)

    Scaffold(modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars),
        topBar = { TopAppBar() }
    ) { innerPadding ->
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                    .fillMaxSize()
                    .background(x)
                    .padding(innerPadding)
                    .padding(horizontal = 12.dp)) {
            Summary(modifier = Modifier
                    .weight(0.5f))
            Spacer(modifier = Modifier.height(12.dp))
            Text("Recent Transactions")
            Spacer(modifier = Modifier.height(12.dp))

            Column(modifier = Modifier
                    .weight(0.8f)
                    .verticalScroll(rememberScrollState())
            ) {
                for (transaction in listOfTransaction) {
                    Transaction(transaction)
                }

            }


        }

    }
}


@Composable
fun Transaction(transaction: Transaction) {
    Surface(color = Color.LightGray,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
        ) {
            Row {
                Surface(shape = RoundedCornerShape(15.dp), color =
                if (transaction.type == "Income") Color.Green.copy(alpha = 0.4f) else Color.Red.copy(
                    alpha = 0.4f), modifier = Modifier.size(30.dp)) {
                    if (transaction.type == "Income") {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")

                    } else {
                        Icon(Icons.Default.KeyboardArrowUp, contentDescription = "")
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(transaction.amount.toString())
            }
            Text(text = transaction.type)
        }
    }
}

data class Transaction(val id: Int,
                       val title: String,
                       val amount: Double,
                       val date: LocalDate,
                       val category: String,
                       val type: String)

val listOfTransaction = listOf(
    Transaction(1, "Salary", 25000.0, LocalDate.now(), "Online", "Income"),
    Transaction(2, "Grocery", 3000.0, LocalDate.now(), "Cash", "Expense"),
    Transaction(3, "Bill", 5000.0, LocalDate.now(), "Online", "Expense"),
    Transaction(4, "Rent", 7000.0, LocalDate.now(), "Cash", "Expense"),
)


@Composable
@Preview
fun MainScreenPreview() {
    MainScreen()
}