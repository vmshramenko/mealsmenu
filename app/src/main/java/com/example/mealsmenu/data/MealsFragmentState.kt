package com.example.mealsmenu.data

data class MealsFragmentState<T>(
    val meals: List<Meal>?,
    val errorMessage: String?,
    val error: Int?,
    val loading: Boolean
)
