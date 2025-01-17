package com.ranamahadahmer.reciperadar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.ranamahadahmer.reciperadar.screens.Home
import com.ranamahadahmer.reciperadar.screens.HomeViewModel
import com.ranamahadahmer.reciperadar.ui.theme.RecipeRadarTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel: HomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            RecipeRadarTheme {
                Home(homeViewModel)
            }
        }
    }
}
