package com.example.mealsmenu.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsmenu.data.DetailsDvo
import com.example.mealsmenu.data.DetailsFragmentState
import com.example.mealsmenu.data.DetailsResponse
import com.example.mealsmenu.data.Ingredient
import com.example.mealsmenu.models.MealsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response

class MealDetailsViewModel(id: String) : ViewModel() {
    private val mealModel = MealsModel()
    val details = MutableStateFlow(DetailsFragmentState(null, null, null, true))

    init{
        fetchMealDetails(id)
    }

    private fun fetchMealDetails(id: String){
        viewModelScope.launch{
            val response = mealModel.getDetailsMeal(id)
            processDetails(response)
        }
    }


    private fun processDetails(response: Response<DetailsResponse>){
        if(response.isSuccessful){
            val ingredients: MutableList<Ingredient> = mutableListOf()
            val detailsDto = response.body()!!.meals.first()

            if(!detailsDto.strIngredient1.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                    strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient1}-Small.png",
                    name = detailsDto.strIngredient1,
                    measure = detailsDto.strMeasure1
                    )
                )
            }
            if(!detailsDto.strIngredient2.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient2}-Small.png",
                        name = detailsDto.strIngredient2,
                        measure = detailsDto.strMeasure2
                    )
                )
            }
            if(!detailsDto.strIngredient3.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient3}-Small.png",
                        name = detailsDto.strIngredient3,
                        measure = detailsDto.strMeasure3
                    )
                )
            }
            if(!detailsDto.strIngredient4.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient4}-Small.png",
                        name = detailsDto.strIngredient4,
                        measure = detailsDto.strMeasure4
                    )
                )
            }
            if(!detailsDto.strIngredient5.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient5}-Small.png",
                        name = detailsDto.strIngredient5,
                        measure = detailsDto.strMeasure5
                    )
                )
            }
            if(!detailsDto.strIngredient6.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient6}-Small.png",
                        name = detailsDto.strIngredient6,
                        measure = detailsDto.strMeasure6
                    )
                )
            }
            if(!detailsDto.strIngredient7.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient7}-Small.png",
                        name = detailsDto.strIngredient7,
                        measure = detailsDto.strMeasure7
                    )
                )
            }
            if(!detailsDto.strIngredient8.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient8}-Small.png",
                        name = detailsDto.strIngredient8,
                        measure = detailsDto.strMeasure8
                    )
                )
            }
            if(!detailsDto.strIngredient9.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient9}-Small.png",
                        name = detailsDto.strIngredient9,
                        measure = detailsDto.strMeasure9
                    )
                )
            }
            if(!detailsDto.strIngredient10.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient10}-Small.png",
                        name = detailsDto.strIngredient10,
                        measure = detailsDto.strMeasure10
                    )
                )
            }
            if(!detailsDto.strIngredient11.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient11}-Small.png",
                        name = detailsDto.strIngredient11,
                        measure = detailsDto.strMeasure11
                    )
                )
            }
            if(!detailsDto.strIngredient12.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient12}-Small.png",
                        name = detailsDto.strIngredient12,
                        measure = detailsDto.strMeasure12
                    )
                )
            }
            if(!detailsDto.strIngredient13.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient13}-Small.png",
                        name = detailsDto.strIngredient13,
                        measure = detailsDto.strMeasure13
                    )
                )
            }
            if(!detailsDto.strIngredient14.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient14}-Small.png",
                        name = detailsDto.strIngredient14,
                        measure = detailsDto.strMeasure14
                    )
                )
            }
            if(!detailsDto.strIngredient15.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient15}-Small.png",
                        name = detailsDto.strIngredient15,
                        measure = detailsDto.strMeasure15
                    )
                )
            }
            if(!detailsDto.strIngredient16.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient16}-Small.png",
                        name = detailsDto.strIngredient16,
                        measure = detailsDto.strMeasure16
                    )
                )
            }
            if(!detailsDto.strIngredient17.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient17}-Small.png",
                        name = detailsDto.strIngredient17,
                        measure = detailsDto.strMeasure17!!
                    )
                )
            }
            if(!detailsDto.strIngredient18.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient18}-Small.png",
                        name = detailsDto.strIngredient18,
                        measure = detailsDto.strMeasure18
                    )
                )
            }
            if(!detailsDto.strIngredient19.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient19}-Small.png",
                        name = detailsDto.strIngredient19,
                        measure = detailsDto.strMeasure19
                    )
                )
            }
            if(!detailsDto.strIngredient20.isNullOrEmpty()){
                ingredients.add(
                    Ingredient(
                        strThumbIngredient = "https://www.themealdb.com/images/ingredients/${detailsDto.strIngredient20}-Small.png",
                        name = detailsDto.strIngredient20,
                        measure = detailsDto.strMeasure20
                    )
                )
            }
            val detailsDvo = DetailsDvo(
                name = detailsDto.strMeal!!,
                strThumbMeal = detailsDto.strMealThumb!!,
                ingredients = ingredients,
                instruction = detailsDto.strInstructions!!,
                serve = detailsDto.strArea!!
            )
            details.update { it.copy(meals = detailsDvo) }
        }else{
            details.update { it.copy(error = response.code(), errorMessage = response.errorBody().toString()) }
        }
    }
}