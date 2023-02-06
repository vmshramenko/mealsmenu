package com.example.mealsmenu.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsmenu.data.DetailsResponse
import com.example.mealsmenu.data.SearchDvo
import com.example.mealsmenu.data.SearchFragmentState
import com.example.mealsmenu.models.MealsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response

class SearchMealViewModel(search: String) : ViewModel() {
    private val mealsModel = MealsModel()
    var search = MutableStateFlow(
        SearchFragmentState(
            null, null, null, true
        )
    )
    init{
        fetchMeals(search)
    }

    private fun fetchMeals(search: String){
        viewModelScope.launch{
            val response = mealsModel.getSearchMeals(search)
            processMeals(response)
        }
    }

    private fun processMeals(response: Response<DetailsResponse>){
        if(response.isSuccessful){
            val searchResult = response.body()?.meals
            val searchList: MutableList<SearchDvo> = mutableListOf()
            searchResult?.forEach{
                searchList.add(
                    SearchDvo(
                        name = it.strMeal!!,
                        image = it.strMealThumb!!,
                        idMeal = it.idMeal!!
                    )
                )
            }
            search.update{ it.copy(search = searchList) }
        }else{
            search.update { it.copy(search = null, error = response.code(), errorMessage = response.errorBody().toString()) }
        }
    }
}