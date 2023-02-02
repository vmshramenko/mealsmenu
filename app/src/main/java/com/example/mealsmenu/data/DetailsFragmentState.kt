package com.example.mealsmenu.data

data class DetailsFragmentState(
    val meals: DetailsDvo?,
    val errorMessage: String?,
    val error: Int?,
    val loading: Boolean?
)