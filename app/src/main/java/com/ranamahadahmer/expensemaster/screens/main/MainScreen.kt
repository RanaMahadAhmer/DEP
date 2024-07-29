package com.ranamahadahmer.expensemaster.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import com.ranamahadahmer.expensemaster.screens.main.components.TransactionCard
import com.ranamahadahmer.expensemaster.screens.main.data.listOfTransaction

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
                    TransactionCard(transaction)
                }
            }
        }
    }
}


@Composable
@Preview
fun MainScreenPreview() {
    MainScreen()
}