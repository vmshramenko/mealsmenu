package com.example.mealsmenu.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class VegetarianViewModel: BaseViewModel() {
    override fun fetchMealsData() {
        viewModelScope.launch {
            val response = mealModel.getVegetarianMeals()
            processMeals(response)
        }
    }
}