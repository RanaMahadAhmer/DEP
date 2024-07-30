package com.ranamahadahmer.reciperadar.api

import com.ranamahadahmer.reciperadar.data.RandomRecipeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.spoonacular.com/"

private val retrofit =
    Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


val api: ApiService = retrofit.create(ApiService::class.java)


interface ApiService {
    @GET("recipes/random/")
    suspend fun getRandomRecipes(
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String
    ): RandomRecipeResponse
}