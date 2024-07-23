package com.ranamahadahmer.reciperadar.data

data class Recipe(
    val id: Int,
    val title: String,
    val readyInMinutes: Int,
    val servings: Int,
    val image: String,
    val summary: String,
    val cuisines: List<String>,
    val dishTypes: List<String>,
    val diets: List<String>,
    val instructions: String,
    val spoonacularSourceUrl: String
)

data class RandomRecipeResponse(
    val recipes: List<Recipe>
)

