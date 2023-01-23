package com.example.mealsmenu.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BreakfastViewModel: BaseViewModel() {

    override fun fetchMealsData() {
        viewModelScope.launch {
            val response = mealModel.getBreakfastMeals()
            processMeals(response)
        }
    }
}