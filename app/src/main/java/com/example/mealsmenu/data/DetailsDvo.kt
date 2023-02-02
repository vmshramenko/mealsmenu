package com.example.mealsmenu.data

data class DetailsDvo(
    val name: String,
    val strThumbMeal: String,
    val ingredients: List<Ingredient>,
    val instruction: String,
    val serve: String
)
