package com.ranamahadahmer.expensemaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ranamahadahmer.expensemaster.screens.main.MainScreen
import com.ranamahadahmer.expensemaster.ui.theme.ExpenseMasterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseMasterTheme {
                MainScreen()
            }
        }
    }
}

