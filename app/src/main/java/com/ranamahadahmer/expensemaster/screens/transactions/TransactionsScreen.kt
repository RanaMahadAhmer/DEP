package com.ranamahadahmer.expensemaster.screens.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ranamahadahmer.expensemaster.R
import com.ranamahadahmer.expensemaster.data.listOfTransaction
import com.ranamahadahmer.expensemaster.screens.transactions.components.TransactionDetailCard
import com.ranamahadahmer.expensemaster.ui.theme.bgGradient

@Composable
fun TransactionsScreen(moveToAddTransaction: () -> Unit, moveToHome: () -> Unit) {


    Scaffold(
        modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
        topBar = {
            Row(modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text("Transactions", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
        },
        bottomBar = {

            NavigationBar(
                containerColor = Color.Transparent,
                modifier = Modifier.height(60.dp)
            ) {
                Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    Icon(painter = painterResource(R.drawable.home),
                        contentDescription = "Home",
                        modifier = Modifier.clickable { moveToHome() })
                    Icon(painter = painterResource(R.drawable.swap),
                        contentDescription = "Transactions")
                    Icon(painter = painterResource(R.drawable.plus),
                        contentDescription = "Add Transaction",
                        modifier = Modifier.clickable { moveToAddTransaction() })
                }
            }
        }

    ) { innerPadding ->
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                    .fillMaxSize()
                    .background(bgGradient)
                    .padding(innerPadding)
                    .padding(horizontal = 12.dp)) {
            Column(modifier = Modifier
                    .weight(0.8f)
                    .verticalScroll(rememberScrollState())
            ) {
                for (transaction in listOfTransaction) {
                    TransactionDetailCard(transaction)
                }
            }
        }
    }
}


@Composable
@Preview
fun TransactionsScreenPreview() {
    TransactionsScreen({}, {})
}