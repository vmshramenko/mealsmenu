package com.example.mealsmenu.models

import android.annotation.SuppressLint
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

    suspend fun getBeefMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getBeefMeals()
        Log.d("GET Beef Result", result.body().toString())

        return result
    }

    suspend fun getChickenMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getChickenMeals()
        Log.d("GET Chicken Result", result.body().toString())

        return result
    }

    suspend fun getGoatMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getGoatMeals()
        Log.d("GET Goat Result", result.body().toString())

        return result
    }

    suspend fun getLambMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getLambMeals()
        Log.d("GET Lamb Result", result.body().toString())

        return result
    }

    @SuppressLint("LongLogTag")
    suspend fun getMiscellaneousMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getMiscellaneousMeals()
        Log.d("GET Miscellaneous Result", result.body().toString())

        return result
    }

    suspend fun getPastaMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getPastaMeals()
        Log.d("GET Pasta Result", result.body().toString())

        return result
    }

    suspend fun getPorkMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getPorkMeals()
        Log.d("GET Pork Result", result.body().toString())

        return result
    }

    suspend fun getSeafoodMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getSeafoodMeals()
        Log.d("GET Seafood Result", result.body().toString())

        return result
    }

    suspend fun getSideMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getSideMeals()
        Log.d("GET Side Result", result.body().toString())

        return result
    }

    suspend fun getVeganMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getVeganMeals()
        Log.d("GET Vegan Result", result.body().toString())

        return result
    }

    suspend fun getVegetarianMeals(): Response<MealsResponse> {
        val quotesApi = RetrofitHelper.getInstance().create(MealsApi::class.java)
        val result = quotesApi.getVegetarianMeals()
        Log.d("GET Vegetarian Result", result.body().toString())

        return result
    }
}