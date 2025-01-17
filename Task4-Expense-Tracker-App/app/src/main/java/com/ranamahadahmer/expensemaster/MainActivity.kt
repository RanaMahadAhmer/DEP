package com.ranamahadahmer.expensemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ranamahadahmer.expensemaster.screens.add_transaction.AddTransaction
import com.ranamahadahmer.expensemaster.screens.add_transaction.AddTransactionModel
import com.ranamahadahmer.expensemaster.screens.home.HomeScreen
import com.ranamahadahmer.expensemaster.screens.transactions.TransactionsScreen
import com.ranamahadahmer.expensemaster.ui.theme.ExpenseMasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseMasterTheme {
                Navigate()
            }
        }
    }
}

@Composable
fun Navigate() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home/") {
        composable("home/") {
            HomeScreen(
                moveToTransactions = {
                    navController.navigate("transactions/")
                },
                moveToAddTransaction = {
                    navController.navigate("add_transaction/")
                }
            )
        }
        composable("transactions/") {
            TransactionsScreen(
                moveToHome = {
                    navController.navigate("home/")
                },
                moveToAddTransaction = {
                    navController.navigate("add_transaction/")
                }
            )
        }
        composable("add_transaction/") {
            AddTransaction(
                moveToHome = {
                    navController.navigate("home/")
                },
                moveToTransactions = {
                    navController.navigate("transactions/")
                },
            )
        }
    }

}