package com.example.mealsmenu.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealsmenu.R
import com.example.mealsmenu.adapters.IngredientsRecyclerAdapter
import com.example.mealsmenu.viewmodels.MealDetailsViewModel

class MealDetailsActivity : AppCompatActivity() {
    @SuppressLint("LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)
        supportActionBar?.hide()

        val detailsViewModel: MealDetailsViewModel
        val idDrink = intent.getStringExtra("idDrink")
        val mealName = findViewById<TextView>(R.id.meal_name)
        val mealImage = findViewById<ImageView>(R.id.meal_image)
        val ingredientsRecycler = findViewById<RecyclerView>(R.id.ingredients_recycler)
        val instruction = findViewById<TextView>(R.id.instruction_details)
        val serve = findViewById<TextView>(R.id.serve_info)
        detailsViewModel = ViewModelProvider(
            this,
            viewModelFactory { MealDetailsViewModel(idDrink!!) }
        )[MealDetailsViewModel::class.java]
        val adapter = IngredientsRecyclerAdapter(emptyList())
        ingredientsRecycler.adapter = adapter

        lifecycleScope.launchWhenStarted {
            detailsViewModel.details.collect {
                if(it.meals != null){
                    adapter.setIngredients(it.meals.ingredients)
                    mealName.text = it.meals.name
                    Glide.with(mealImage.context)
                        .load(it.meals.strThumbMeal)
                        .into(mealImage)
                    instruction.text = it.meals.instruction
                    serve.text = it.meals.serve
                }
            }
        }

        if (idDrink != null) {
            Log.d("GET activity details ID MEAL", idDrink)
        }
    }
    private inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = f() as T
        }

}