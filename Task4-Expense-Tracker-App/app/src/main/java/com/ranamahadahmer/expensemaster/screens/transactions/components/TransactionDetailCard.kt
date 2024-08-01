package com.ranamahadahmer.expensemaster.screens.transactions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranamahadahmer.expensemaster.data.Transaction
import java.time.LocalDate

@Composable
fun TransactionDetailCard(transaction: Transaction) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 4.dp,
        modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp)) {
        Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = transaction.title, fontSize = 20.sp, fontWeight = FontWeight.W500)
                Row {
                    if (transaction.type == "Income") {
                        Icon(Icons.Default.KeyboardArrowDown,
                            contentDescription = "Incoming Icon",
                            tint = Color.Green)
                    } else {
                        Icon(Icons.Default.KeyboardArrowUp,
                            contentDescription = "Outgoing Icon",
                            tint = Color.Red)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = transaction.amount.toString(),
                        fontSize = 16.sp,
                        color = if (transaction.type == "Income") Color.Green else Color.Red,
                        fontWeight = FontWeight.ExtraBold)
                }


            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = transaction.category)
                Text(text = transaction.date.toString())
            }
        }
    }
}

@Preview
@Composable
fun TransactionDetailCardPreview() {
    TransactionDetailCard(Transaction(1, "Salary", 25000.0, LocalDate.now(), "Online", "Expense"))
}