package com.example.mealsmenu.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("filter.php?c=Breakfast")
    suspend fun getBreakfastMeals(): Response<MealsResponse>

    @GET("filter.php?c=Starter")
    suspend fun getStarterMeals(): Response<MealsResponse>

    @GET("filter.php?c=Dessert")
    suspend fun getDessertMeals(): Response<MealsResponse>

    @GET("filter.php?c=Beef")
    suspend fun getBeefMeals(): Response<MealsResponse>

    @GET("filter.php?c=Chicken")
    suspend fun getChickenMeals(): Response<MealsResponse>

    @GET("filter.php?c=Goat")
    suspend fun getGoatMeals(): Response<MealsResponse>

    @GET("filter.php?c=Lamb")
    suspend fun getLambMeals(): Response<MealsResponse>

    @GET("filter.php?c=Miscellaneous")
    suspend fun getMiscellaneousMeals(): Response<MealsResponse>

    @GET("filter.php?c=Pasta")
    suspend fun getPastaMeals(): Response<MealsResponse>

    @GET("filter.php?c=Pork")
    suspend fun getPorkMeals(): Response<MealsResponse>

    @GET("filter.php?c=Seafood")
    suspend fun getSeafoodMeals(): Response<MealsResponse>

    @GET("filter.php?c=Side")
    suspend fun getSideMeals(): Response<MealsResponse>

    @GET("filter.php?c=Vegan")
    suspend fun getVeganMeals(): Response<MealsResponse>

    @GET("filter.php?c=Vegetarian")
    suspend fun getVegetarianMeals(): Response<MealsResponse>

    @GET("lookup.php")
    suspend fun getMealDetails(@Query("i") search: String): Response<DetailsResponse>
}