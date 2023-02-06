package com.example.mealsmenu.data

data class SearchFragmentState(
    val search: List<SearchDvo>?,
    val errorMessage: String?,
    val error: Int?,
    val loading: Boolean
)
