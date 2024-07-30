package com.ranamahadahmer.expensemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ranamahadahmer.expensemaster.screens.main.MainScreen
import com.ranamahadahmer.expensemaster.screens.transaction.TransactionScreen
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
    NavHost(navController, startDestination = "transaction/") {
        composable("main/") { MainScreen() }
        composable("transaction/") { TransactionScreen() }
    }

}