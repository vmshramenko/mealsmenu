package com.example.mealsmenu.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsmenu.data.Meal
import com.example.mealsmenu.data.MealsFragmentState
import com.example.mealsmenu.data.MealsResponse
import com.example.mealsmenu.models.MealsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private var mealsModel = MealsModel()
    val breakfastMeal =
        MutableStateFlow<MealsFragmentState<List<Meal>>>(MealsFragmentState(null, null, null, true))
    val dessertMeal =
        MutableStateFlow<MealsFragmentState<List<Meal>>>(MealsFragmentState(null, null, null, true))

    init{
        fetchBreakfastMeals()
        fetchDessertMeals()
    }

    private fun fetchBreakfastMeals(){
        viewModelScope.launch {
            val response = mealsModel.getBreakfastMeals()
            processBreakfastMeals(response)
        }
    }

    private fun fetchDessertMeals(){
        viewModelScope.launch {
            val response = mealsModel.getDessertMeals()
            processDessertMeals(response)
        }
    }

    private fun processBreakfastMeals(response: Response<MealsResponse>) {
        if (response.isSuccessful) {
            breakfastMeal.update { it.copy(meals = response.body()!!.meals) }
        } else {
            breakfastMeal.update {
                it.copy(
                    error = response.code(),
                    errorMessage = response.errorBody().toString()
                )
            }
        }
    }

    private fun processDessertMeals(response: Response<MealsResponse>) {
        if (response.isSuccessful) {
            dessertMeal.update { it.copy(meals = response.body()!!.meals) }
        } else {
            dessertMeal.update {
                it.copy(
                    error = response.code(),
                    errorMessage = response.errorBody().toString()
                )
            }
        }
    }
}