package com.ranamahadahmer.expensemaster.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranamahadahmer.expensemaster.R
import com.ranamahadahmer.expensemaster.data.listOfTransaction
import com.ranamahadahmer.expensemaster.screens.home.components.Summary
import com.ranamahadahmer.expensemaster.screens.home.components.TopAppBar
import com.ranamahadahmer.expensemaster.screens.home.components.TransactionCard
import com.ranamahadahmer.expensemaster.ui.theme.bgGradient

@Composable
fun HomeScreen(
    moveToAddTransaction: () -> Unit,
    moveToTransactions: () -> Unit) {

    Scaffold(
        modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
        topBar = { TopAppBar() },
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
                    Icon(painter = painterResource(R.drawable.home), contentDescription = "Home")
                    Icon(painter = painterResource(R.drawable.swap), contentDescription = "Transactions",modifier = Modifier.clickable { moveToTransactions() })
                    Icon(painter = painterResource(R.drawable.plus), contentDescription = "Add Transaction",modifier = Modifier.clickable { moveToAddTransaction() })
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
                    TransactionCard(transaction)
                }
            }
        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen({},{})
}