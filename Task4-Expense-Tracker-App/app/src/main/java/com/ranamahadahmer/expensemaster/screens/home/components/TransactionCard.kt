package com.ranamahadahmer.expensemaster.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranamahadahmer.expensemaster.data.Transaction
import java.time.LocalDate

@Composable
fun TransactionCard(transaction: Transaction) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 4.dp,
        modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

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

@Preview
@Composable
fun TransactionCardPreview() {
    TransactionCard(Transaction(1, "Salary", 25000.0, LocalDate.now(), "Online", "Income"))
}