package com.example.mealsmenu.models

import android.util.Log
import com.example.mealsmenu.data.MealsApi
import com.example.mealsmenu.data.MealsResponse
import com.example.mealsmenu.data.RetrofitHelper
import retrofit2.Response

class MealsModel {
    suspend fun getBreakfastMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getBreakfastMeals()
        Log.d("GET Breakfast Result", result.body().toString())

        return result
    }

    suspend fun getStarterMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getStarterMeals()
        Log.d("GET Starter Result", result.body().toString())

        return result
    }

    suspend fun getDessertMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getDessertMeals()
        Log.d("GET Dessert Result", result.body().toString())

        return result
    }
}