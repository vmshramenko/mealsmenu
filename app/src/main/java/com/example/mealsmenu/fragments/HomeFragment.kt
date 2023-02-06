package com.example.mealsmenu.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealsmenu.R
import com.example.mealsmenu.activity.MealDetailsActivity
import com.example.mealsmenu.activity.SearchMealActivity
import com.example.mealsmenu.adapters.HomeRecyclerAdapter
import com.example.mealsmenu.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var breakfastAdapter: HomeRecyclerAdapter
    private lateinit var dessertAdapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        val recyclerBreakfast = view.findViewById<RecyclerView>(R.id.recycler_breakfast)
        val recyclerDessert = view.findViewById<RecyclerView>(R.id.recycler_dessert)
        val searchView = view.findViewById<View>(R.id.search_meals)
        breakfastAdapter = HomeRecyclerAdapter(emptyList(), clickListener = { id ->  launchMealDetails(id) })
        dessertAdapter = HomeRecyclerAdapter(emptyList(), clickListener = { id ->  launchMealDetails(id) })
        recyclerBreakfast.adapter = breakfastAdapter
        recyclerDessert.adapter = dessertAdapter

        lifecycleScope.launchWhenStarted {
            homeViewModel.breakfastMeal.collect {
                when {
                    !it.meals.isNullOrEmpty() -> {
                        breakfastAdapter.setMeals(it.meals)
                    }
                    !it.errorMessage.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            homeViewModel.dessertMeal.collect {
                when {
                    !it.meals.isNullOrEmpty() -> {
                        dessertAdapter.setMeals(it.meals)
                    }
                    !it.errorMessage.isNullOrEmpty() -> {
                        Toast.makeText(requireContext(), it.errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        searchView.setOnClickListener {
            val intent = Intent(it.context, SearchMealActivity::class.java)
            startActivity(intent)
        }
    }


    private fun launchMealDetails(id: Int){
        Log.d("SENT id drink", id.toString())
        if(activity != null){
            val intent = Intent(context, MealDetailsActivity::class.java)
            intent.putExtra("idDrink", id.toString())
            startActivity(intent)
        }
    }
}