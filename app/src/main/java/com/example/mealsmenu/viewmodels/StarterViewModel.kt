package com.example.mealsmenu.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StarterViewModel: BaseViewModel() {
    override fun fetchMealsData() {
        viewModelScope.launch {
            val response = mealModel.getStarterMeals()
            processMeals(response)
        }
    }
}