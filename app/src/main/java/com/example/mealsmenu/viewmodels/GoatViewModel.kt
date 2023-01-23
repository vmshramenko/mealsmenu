package com.example.mealsmenu.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GoatViewModel: BaseViewModel() {
    override fun fetchMealsData() {
        viewModelScope.launch {
            val response = mealModel.getGoatMeals()
            processMeals(response)
        }
    }
}