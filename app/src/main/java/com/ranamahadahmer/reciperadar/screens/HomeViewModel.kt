package com.ranamahadahmer.reciperadar.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranamahadahmer.reciperadar.api.api
import com.ranamahadahmer.reciperadar.data.Recipe
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val recipesState: State<HomeState> = _state

    init {
        fetchRecipes()
    }

    fun fetchRecipes() {
        viewModelScope.launch {


            try {

                val recipes = api.getRandomRecipes(98, "1b740b9b597e4f3698e91c1ea931f300")
                _state.value = HomeState(list = recipes.recipes, loading = false, error = null)
            } catch (e: Exception) {
                _state.value = HomeState(loading = false, error = e.message)

            }
        }

    }

    data class HomeState(val loading: Boolean = true,
                         val list: List<Recipe> = emptyList(),
                         val error: String? = null
    )

}
