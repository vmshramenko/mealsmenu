package com.example.mealsmenu.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BeefViewModel : BaseViewModel() {
    override fun fetchMealsData() {
        viewModelScope.launch {
            val response = mealModel.getBeefMeals()
            processMeals(response)
        }
    }
}