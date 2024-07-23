package com.ranamahadahmer.reciperadar.screens

import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.ranamahadahmer.reciperadar.data.Recipe
import com.ranamahadahmer.reciperadar.screens.components.RecipeCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {

    var show by remember { mutableStateOf(false) }
    val mode: HomeViewModel = viewModel()
    val viewState by mode.recipesState
    var selectedItem by remember {
        mutableStateOf<Recipe>(Recipe(1,
            "", 1, 1, "", "", emptyList(), emptyList(), emptyList(), "", ""))
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title =
                {
                    Row(modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            "Recipes",
                            fontSize = 30.sp,
                        )
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Outlined.Search,
                                contentDescription = "",
                                modifier = Modifier.size(50.dp))
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            Button(onClick = {
                mode.fetchRecipes()
            }, modifier = Modifier.height(42.dp)) {
                Text("Random")
                Spacer(modifier = Modifier.width(5.dp))
                Icon(imageVector = Icons.Outlined.Refresh, contentDescription = "Random")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                    .padding(innerPadding)
                    .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                viewState.loading -> {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Loading..")
                    }
                }

                viewState.error != null -> {
                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Check your Network Connection")
                    }
                }

                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 150.dp),
                        modifier = Modifier
                                .padding(bottom = 50.dp)
                    ) {
                        items(viewState.list) { item ->
                            RecipeCard(item, show = {
                                show = true
                                selectedItem = item
                            })
                        }
                    }
                }
            }
        }

        if (show) {
            AlertDialog(
                title = { Text(text = "Recipe") },
                onDismissRequest = {
                    show = false
                },
                confirmButton = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = rememberAsyncImagePainter(model = selectedItem.image),
                            contentDescription = "Image of Meal",
                        )
                        TextField(
                            value = selectedItem.title,
                            onValueChange = { },
                            enabled = false,
                            label = {
                                Text(text = "Recipe Name",
                                    fontWeight = FontWeight.Bold)
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = Html.fromHtml(selectedItem.instructions).toString(),
                            onValueChange = { },
                            enabled = false,
                            modifier = Modifier.verticalScroll(rememberScrollState()),
                            label = { Text(text = "Recipe Details") }
                        )

                    }
                },
            )
        }
    }

}


