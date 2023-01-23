package com.example.mealsmenu.data

import retrofit2.Response
import retrofit2.http.GET

interface MealsApi {
    @GET("filter.php?c=Breakfast")
    suspend fun getBreakfastMeals(): Response<MealsResponse>

    @GET("filter.php?c=Starter")
    suspend fun getStarterMeals(): Response<MealsResponse>

    @GET("filter.php?c=Dessert")
    suspend fun getDessertMeals(): Response<MealsResponse>
}