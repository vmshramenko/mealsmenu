package com.example.mealsmenu.viewmodels

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PastaViewModel: BaseViewModel() {
    override fun fetchMealsData() {
        viewModelScope.launch {
            val response = mealModel.getPastaMeals()
            processMeals(response)
        }
    }
}