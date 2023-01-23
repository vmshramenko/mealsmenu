package com.example.mealsmenu.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mealsmenu.data.Meal
import com.example.mealsmenu.data.MealsFragmentState
import com.example.mealsmenu.data.MealsResponse
import com.example.mealsmenu.models.MealsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Response

abstract class BaseViewModel: ViewModel() {
    protected var mealModel = MealsModel()
    val meal = MutableStateFlow<MealsFragmentState<List<Meal>>>(
        MealsFragmentState(null, null, null, true)
    )

    init{
        fetchMealsData()
    }

    abstract fun fetchMealsData()

    fun processMeals(response: Response<MealsResponse>) {
        if(response.isSuccessful){
            meal.update { it.copy(meals = response.body()?.meals) }
        }else{
            meal.update { it.copy(error = response.code(), errorMessage = response.errorBody().toString() ) }
        }
    }
}